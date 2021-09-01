package com.mayur.patterns.singleton;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestSingleton {

    public static void main(String[] args){

        Runnable r1 = () -> System.out.println(Thread.currentThread().getName() +" ___ "+Singleton.getInstance().toString());
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
//        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);

        for (int i =0; i< 20; i++){

            executor.execute(r1);
//            executor.scheduleWithFixedDelay(r1,2,2, TimeUnit.SECONDS);
        }
        executor.shutdown();

    }

}
