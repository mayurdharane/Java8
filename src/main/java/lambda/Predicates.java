package lambda;

import interfaces.CarSupplier;
import model.Car;

import java.util.function.Predicate;

public class Predicates {

    public static void main(String[] args){

        Predicate<Car> electricCar =  (car) -> car.isElectric(); //Car::isElectric

        Predicate<Car> isMaruti = (car -> car.getName().equalsIgnoreCase("Maruti"));

        Predicate<Car> isElectricMaruti = isMaruti.and(electricCar);

        CarSupplier<String,Integer,Boolean,Double,Car> carSupplier = Car::new;
        Car maruti = carSupplier.getCar("Maruti", 4, Boolean.TRUE, 1254.23);
        maruti.toString();

        System.out.println(isElectricMaruti.test(maruti));


    }

}
