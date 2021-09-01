package com.mayur.patterns.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    //version 1
    public static synchronized ThreadSafeSingleton getInstance(){
        if (instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    //version 2
    public static ThreadSafeSingleton getInstance1(){
        if (instance == null){
            synchronized (ThreadSafeSingleton.class){
                instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }


}
