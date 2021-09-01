package com.mayur.patterns.singleton;

public class LazyInitializedSingleton {

    private static volatile LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {    }

    public static LazyInitializedSingleton getInstance() {
        if(instance == null){
            return instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
