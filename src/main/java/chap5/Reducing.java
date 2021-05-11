package chap5;

import chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static chap4.Dish.menu;
import static java.util.stream.Collectors.groupingBy;

public class Reducing{

    public static void main(String...args){

        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        Integer sum = numbers.stream().reduce(1, (a, b) -> a + b).intValue();
        System.out.println(sum);

        Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a * b);
        System.out.println(reduce);

        Map<Integer, List<Dish>> collect1 = menu.stream().collect(groupingBy(Dish::getCalories));

        Integer reduce1 = menu.stream().map(d -> d.getCalories()).reduce(0, Integer::sum);
        Optional<Integer> reduce2 = menu.stream().map(d -> d.getCalories()).reduce((a, b) -> a + b);
        System.out.println(reduce2);

        System.out.println(numbers.stream().reduce(Integer::max));
        System.out.println(numbers.stream().reduce(Integer::min));
        System.out.println(numbers.stream().reduce(Integer::rotateLeft));


    }
}
