package com.java.robin.controller;

import com.java.concepts.MyPriorityQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/pq")
public class PQController {

    Logger log = LoggerFactory.getLogger(PQController.class);

    Integer currentValue = null;
    Integer putValue = null;

    @Autowired
    private MyPriorityQueue myPriorityQueue;

    @GetMapping("/list")
    public String list() {
        log.info("Get list");
        return myPriorityQueue.getList();
    }

    @GetMapping("/getValue")
    public Object getValue() throws InterruptedException {

        log.info("Get value");

        Runnable run = () -> {
            try {
                Integer  number  = myPriorityQueue.get();
                this.currentValue = number;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(run);
        int waitSec = 5;
        while (!future.isDone() || waitSec > 0){
            Thread.sleep(1000);
            waitSec--;
        }
        return currentValue;
    }

    @GetMapping("/putValue/{number}")
    public String putValue(@PathVariable("number") Integer number) throws InterruptedException {
        log.info("put value {}",number);
        putValue = number;
        String output = null;
        Runnable run = () -> {
            try {
                myPriorityQueue.put(putValue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(run);
        int waitSec = 5;
        while (!future.isDone() || waitSec > 0){
            Thread.sleep(1000);
            waitSec--;
        }
        if(waitSec==0){
            return "waiting state";
        }
        return "Done";
    }


}
