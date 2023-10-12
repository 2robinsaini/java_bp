package com.java.concepts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleSeconfhigh {

    public static void main(String[] args) {



        List<Integer> myList = Arrays.asList(1,2,31,3,4,5,63,5,6,4,74,67);
        int p =  myList.stream().mapToInt(value -> value).sum();
        int p1 = myList.stream().sorted((i1,i2) -> { return (i2-i1);}).limit(3).min((i1,i2) -> {return (i1-i2);}).get();
        int p2 = myList.stream().sorted((i1,i2) -> { return (i2-i1);}).limit(3).sorted().findFirst().get();
        int p3 = myList.stream().sorted((i1,i2) -> { return (i2-i1);}).limit(3).peek(e -> System.out.println(e)).sorted().findFirst().get();
        System.out.println(p+ " " + p1 + " " + p2);




    }

}
