package chap5;


import chap4.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static chap4.Dish.menu;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Mapping {

    public static void main(String... args) {

        //low calorie dish
//        menu.stream().filter(d-> d.getCalories() < 400).map(d -> d.getName()).forEach(System.out::println);

//        menu.stream().filter(d -> d.getCalories() < 400).map(d -> d.getName()).sorted().forEach(System.out::println);

        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));

        Map<Integer, List<Dish>> collect1 = menu.stream().collect(groupingBy(Dish::getCalories));

        System.out.println(collect1);


        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[]{i, j})
                        )
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                        .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
