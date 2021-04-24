package lambdainaction.chapter1;

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

        List<Apple> greenApples = filterApples(inventory, greenApplePredicate);
//        System.out.println(greenApples);

        // green apple
//        inventory.stream().filter(greenApplePredicate).forEach(System.out::println);

        //heavy green apple
//        inventory.stream().filter(greenHeavyApplePredicate).forEach(System.out::println);

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.weight));
//        System.out.println(inventory);

        Comparator<Apple> appleComparator = Comparator.comparingInt(Apple::getWeight);
        inventory.sort(appleComparator);
//        System.out.println(inventory);

        inventory.sort(Comparator.comparing(Apple::getColor));
        System.out.println(inventory);






    }











    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "\n Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
