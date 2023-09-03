package com.java.concepts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyPriorityQueue {

    Logger log = LoggerFactory.getLogger(MyPriorityQueue.class);

    private List<Integer> sharedList = new ArrayList<>();
    int maxSizeOfList = 10;

    public synchronized void put(int i) throws InterruptedException {
        log.info("request putting {}",i);
        while(sharedList.size()==maxSizeOfList){
            wait();
        }
        if(sharedList.size()==0){
            notifyAll();
        }
        sharedList.add(i);
        log.info("Value put {}",i);
    }

    public synchronized int get() throws InterruptedException {
        log.info("get current element of list");
        while(sharedList.size()==0){
            wait();
        }
        if(sharedList.size()==maxSizeOfList){
            notifyAll();
        }
        log.info("current element of list {}",sharedList.size()-1);
        Integer i = sharedList.get(sharedList.size()-1);
        sharedList.remove(sharedList.size()-1);
        return i ;
    }

    public String getList()  {
            log.info("List {}",sharedList.toString());
            return sharedList.toString() ;
    }


}
