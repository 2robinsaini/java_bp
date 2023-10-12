package com.java.concepts;

import java.util.Arrays;

public class PrimeNum {
    public static void main(String[] args) {

        int num = 4;
        int[] answer = new int[num];
        int count = 0;

        boolean isPrime = checkForPrime(num);

        for(int i=2;i<num;i++){
            if(checkForPrime(i)){
                answer[count++] = i;
            }
        }

        Arrays.stream(answer).filter(i -> i!=0).forEach(System.out::println);

        

    }

    private static boolean checkForPrime(int num) {
        for(int i=2;i<num-1;i++){
            if(num%i==0){
               return false;
            }
        }
        return true;
    }


}
