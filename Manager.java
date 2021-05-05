import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Manager {
    Set<Goods> goodsSortedByName;
    Set<Goods> goodsSortedByNameReversed;
    Set<Goods> goodsSortedByPriceThenByName;
    Set<Goods> goodsSortedByNameNullsFirst;

    public Manager(){
        goodsSortedByName = new TreeSet<>(Goods.comparatorByName);
        goodsSortedByNameReversed = new TreeSet<>(Goods.comparatorByName.reversed());
        goodsSortedByPriceThenByName = new TreeSet<>(Goods.comparatorByPrice.thenComparing(Goods.comparatorByName));
        goodsSortedByNameNullsFirst = new TreeSet<>(Comparator.nullsFirst(Goods.comparatorByName));
    }

    public void addConsumerGoods(ConsumerGoods g){
        try {
            if (g.getId() <= 0) throw new IllegalArgumentException("Id is not correct");
            if (g.getPrice() <= 0) throw new IllegalArgumentException("Price is not correct");
            if (g.getWeight() <= 0) throw new IllegalArgumentException("Weight is not correct");
            goodsSortedByName.add(g);
            goodsSortedByNameReversed.add(g);
            goodsSortedByPriceThenByName.add(g);
            goodsSortedByNameNullsFirst.add(g);
        } catch (Exception err){
            System.out.println(err.getMessage());
        }
    }

    public void addNull(ConsumerGoods g){
        goodsSortedByNameNullsFirst.add(g);
    }

    public void display(){
        System.out.println("Sorted by Name:");
        for (var good: goodsSortedByName) {
            System.out.println(good);
        }
        System.out.println("==================================");
        System.out.println("Reverse Sorted By Name:");
        for (var good: goodsSortedByNameReversed) {
            System.out.println(good);
        }
        System.out.println("==================================");
        System.out.println("Sorted by Price Then by Name:");
        for (var good: goodsSortedByPriceThenByName) {
            System.out.println(good);
        }
    }

    public void nullsDisplay(){
        System.out.println("==================================");
        System.out.println("Sorted by Name with FirstNulls:");
        for (var good: goodsSortedByNameNullsFirst) {
            System.out.println(good);
        }
    }

}
