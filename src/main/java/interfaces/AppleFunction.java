package interfaces;

import model.Apple;

import java.util.function.Function;

@FunctionalInterface
public interface AppleFunction<T,X> {

    Apple getHeavierApple(Apple apple1, Apple apple2);
}
