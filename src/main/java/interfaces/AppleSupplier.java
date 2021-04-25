package interfaces;

import model.Apple;

@FunctionalInterface
public interface AppleSupplier<T,U,X> {
    Apple getApple(T t, U u);
}
