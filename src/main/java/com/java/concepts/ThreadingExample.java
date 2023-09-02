package com.java.concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadingExample {


    public static void main(String[] args) {

        executorExample();

    }

    private static void executorExample() {

        Runnable task = () -> {
            System.out.println("Runnng task");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task complete");
        };


        Thread th = new Thread(task);
        th.start();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        executorService2.execute(task);
        executorService.execute(task);
        Future future = executorService2.submit(task);
        executorService2.shutdown();
        executorService.shutdown();


    }


}
