package lambdainaction.chapter1;

import interfaces.AppleFunction;
import interfaces.AppleSupplier;
import model.Apple;

import java.util.function.*;
import java.util.stream.Stream;

public class AllFunctionalInterfacesImpl {

    public static void main(String[] args){

        java.util.function.Predicate<Apple> isRedApple = (Apple a) -> "red".equals(a.getColor());

        java.util.function.Supplier<Apple> appleSupplier =  () -> new Apple(10,"red");
        Apple redApple = appleSupplier.get();
        System.out.println(isRedApple.test(redApple));


        java.util.function.Function<Apple,String> appleColorFunction = (Apple::getColor);
        java.util.function.Function<Apple,String> appleColorFunction1 = (Apple a)-> a.getColor();

        IntPredicate evenNumber = (int number) -> number %2 == 0;
        System.out.println(evenNumber.test(4));

        Consumer<Apple> appleConsumer = (Apple a) -> System.out.println("For Consumer :: "+a.toString());
        appleConsumer.accept(appleSupplier.get());

        Consumer<String> printConsumer = s -> System.out.println(s);
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);


        Consumer<Number> numberPrinter = num -> System.out.println(num);
        IntToDoubleFunction intToDoubleFunction = t -> Double.valueOf(Integer.toString(t));
        numberPrinter.accept(intToDoubleFunction.applyAsDouble(50));

        ToDoubleFunction<Apple> toDoubleFunction = (Apple a) -> Double.valueOf(Integer.toString(a.getWeight()));
        numberPrinter.accept(toDoubleFunction.applyAsDouble(redApple));

        IntUnaryOperator intUnaryOperator = t -> t * t;
        numberPrinter.accept(intUnaryOperator.applyAsInt(50));

//        BinaryOperator<Apple, Apple>

        AppleSupplier<Integer,String, Apple> appleSupplier1 = Apple::new;
        Apple greenApple = appleSupplier1.getApple(300, "GREEN");
        Apple redishApp = appleSupplier1.getApple(200, "RED");


        AppleFunction<Apple, Apple> getHeavierApple = (Apple a1, Apple a2) -> a1.getWeight()> a2.getWeight()?a1:a2;
        Apple heavierApple = getHeavierApple.getHeavierApple(greenApple, redishApp);
        appleConsumer.accept(heavierApple);


        appleConsumer.accept(redishApp);
        BiConsumer<Apple,String> appleColorChanger = (apple, newColor) -> apple.setColor(newColor);
        appleColorChanger.accept(redishApp,"Very Green");
        appleConsumer.accept(redishApp);



    }








}
