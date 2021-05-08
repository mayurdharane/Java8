package model;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Student implements Adder {

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;


    @Override
    public Integer increaseAge(Integer a, Function<Integer, Integer> f) {
        return f.apply(a);
    }

    @Override
    public void increaseAgeAndPrintName(List<Student> students, Predicate studentPredicate, Consumer consumer, IntFunction intFunction) { //, Function function

        for (Student student : students) {
            if (studentPredicate.test(student)) {
                consumer.accept(student);
                student.setAge((Integer) intFunction.apply(student.age));
                consumer.accept(student);
                //function.apply(student.name);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
