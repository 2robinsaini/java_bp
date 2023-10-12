package com.java.concepts;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.regex.Pattern;


class A{
    int a = 18;

    public void print(){
        System.out.println("in Parent");
    }

}


public class SamplePractice extends A {


 int a = 10;

    public static void main(String[] args) {


       A aa = new SamplePractice();
        System.out.println(aa.a);
        aa.print();


    }

    public void print(){
        System.out.println("in Child");
    }
}


