package lambda;

import model.Student;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.*;

public class LambadaRunner {

    public static void main(String[] args) {


        Function<Integer, Integer> adder10 = (a) -> {
            return a + 10;
        };
        Consumer<Integer> printer = (age) -> System.out.println(age);

        // printer.accept(Calendar.getInstance().get(Calendar.YEAR) + 10);
        int size = 2030 - Calendar.getInstance().get(Calendar.YEAR) + 11;
        System.out.println("Size :" + size);
        System.out.println(Calendar.getInstance().get(Calendar.YEAR) + 20);
        Integer _years[] = new Integer[size];


        Student student = null;
//        Student student = Student::new;
        Supplier<Student> studentSupplier = Student::new;
        student = studentSupplier.get();
        printer.accept(student.increaseAge(10, adder10));


        Student s1 = new Student("A", 1);
        Student s2 = new Student("B", 10);
        Student s3 = new Student("C", 5);
        Student s4 = new Student("D", 8);

        Predicate<Student> oldStudents = (Student s) -> s.getAge() >= 18;
        Predicate<Student> youngerStudents = (Student s) -> s.getAge() <= 5;
        IntFunction youngerToAdult = (age) -> {
            return age + 20;
        };
        Consumer<Student> studentConsumer = (Student s) -> System.out.println(s);

        List<Student> studentsList = Arrays.asList(s1, s2, s3, s4);
        student.increaseAgeAndPrintName(studentsList,
                youngerStudents, studentConsumer, youngerToAdult);

    }

}
