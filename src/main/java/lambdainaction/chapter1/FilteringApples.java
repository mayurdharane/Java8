package lambdainaction.chapter1;

import model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public  static void main(String[] args){

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(185, "red"),
                new Apple(100, "green"),
                new Apple(180, "pink"),
                new Apple(120, "pink"));


        Predicate<Apple> greenApplePredicate = (Apple a) -> "green".equals(a.getColor());
        Predicate<Apple> redApplePredicate = (Apple a) -> "red".equals(a.getColor());
        Predicate<Apple> greenHeavyApplePredicate = (Apple a) -> "green".equals(a.getColor()) && 150 < a.getWeight();

        List<Apple> greenApples = Apple.filterApples(inventory, greenApplePredicate);
//        System.out.println(greenApples);

        // green apple
//        inventory.stream().filter(greenApplePredicate).forEach(System.out::println);

        //heavy green apple
//        inventory.stream().filter(greenHeavyApplePredicate).forEach(System.out::println);

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
//        System.out.println(inventory);

        Comparator<Apple> appleComparator = Comparator.comparingInt(Apple::getWeight);
        inventory.sort(appleComparator);
//        System.out.println(inventory);

        inventory.sort(Comparator.comparing(Apple::getColor));
        System.out.println(inventory);






    }












}
