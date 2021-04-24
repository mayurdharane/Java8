package lambda;

import model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {

    public MethodReferences() {
    }

    public static void main(String[] args){

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        MethodReferences methodReferences = new MethodReferences();
       // methodReferences.print(Arrays.asList(stringArray.clone()), s -> System.out.println(s));

//        methodReferences.print1(Arrays.asList(stringArray.clone()), s -> s.length()<5,s -> System.out.println(s));

//        methodReferences.print2(Arrays.asList(stringArray.clone()), s -> s.length() < 5, s -> s+"-TEST",s -> System.out.println(s));

        Supplier<Car> carSupplier = Car::new;
        Car pertolCar = carSupplier.get();
        System.out.println(pertolCar);

        Function<String,Integer> stringIntegerFunction = Integer::parseInt;
        System.out.println(stringIntegerFunction.apply("23"));
        System.out.println(Integer.compare(23,stringIntegerFunction.apply("23")));

        Predicate<Car> isCarElectric = Car::isElectric;
        pertolCar.setElectric(true);
        System.out.println(isCarElectric.test(pertolCar));

        Function<String, Car> createCarByName =  Car::new;
        Function<String, Car> createCarByName1 =  (name) -> new Car(name);//Car::new;
        System.out.println(createCarByName.apply("Maruti Ritz"));
        System.out.println(createCarByName1.apply("Tata Safari"));






    }

    private void print (List<String> names, Consumer<String> consumer){
        names.forEach(name -> consumer.accept(name));
    }

    private void print1 (List<String> names,
                         Predicate<String> predicate,
                         Consumer<String> consumer){
        names.forEach(name -> {
                if(predicate.test(name)) {
                consumer.accept(name);
            }
        }
        );
    }

    private void print2 (List<String> names, Predicate<String> predicate,
                         Function<String,String> function,
                         Consumer<String> consumer){
        names.forEach(name -> {
                    if(predicate.test(name)) {
                        String name1  = function.apply(name);
                        consumer.accept(name1);
                    }
                }
        );
    }
}
