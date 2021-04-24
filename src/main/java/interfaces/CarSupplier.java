package interfaces;

import java.util.function.Supplier;

@FunctionalInterface
public interface CarSupplier<T,U,V,X,Y> {

    Y getCar (T t,U u,V v,X x);
}
