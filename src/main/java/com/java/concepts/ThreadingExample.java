package com.java.concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;

public class ThreadingExample {


    public static void main(String[] args) {

        executorExample();

    }

    private static void executorExample() {

        Runnable task = () -> {
            System.out.println("Running task");
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
        ExecutorService executorService3 = Executors.newCachedThreadPool();
        ExecutorService executorService4 = Executors.newWorkStealingPool();
        executorService.execute(task);
        executorService2.execute(task);
        Future future = executorService2.submit(task);
        Future future2 = executorService3.submit(task);
        Future future3 = executorService4.submit(task);
        executorService.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        executorService4.shutdown();

        while (!future.isDone()){
            System.out.println("future is still running");
            LockSupport.parkNanos(200);
        }
        while (!future2.isDone()){
            System.out.println("future2 is still running");
            LockSupport.parkNanos(200);
        }
        while (!future3.isDone()){
            System.out.println("future3 is still running");
            LockSupport.parkNanos(200);
        }



    }


}
