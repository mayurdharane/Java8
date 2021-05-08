package model;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public interface Adder {

    Integer increaseAge(Integer a, Function<Integer, Integer> f);

    void increaseAgeAndPrintName(List<Student> students,
                                 Predicate studentPredicate,
                                 Consumer consumer,
                                 IntFunction intFunction); //,Function function
}
