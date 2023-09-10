package com.java.concepts;

import java.util.*;

public class SimpleCollection {


    public static void main(String[] args) {

        String[] sArray = new String[3];
        sArray[0] = "ABC-1";
        sArray[1] = "ABC-2";
        sArray[2] = "ABC-3";
        //sArray[3] = "ABC-4";

        for(int i=0;i<sArray.length;i++){
            System.out.println(sArray[i]);
        }

        System.out.println("------------------");

        //List<String> sList = new ArrayList<>();
        Set<String> sList = new HashSet<>();
        sList.add("India");
        sList.add("US");
        sList.add("UK");
        sList.add("London");
        sList.add("malasia");
        sList.add("peris");
        sList.add("India");
        sList.add("US");
        sList.add("UK");
        sList.add("London");
        sList.add("malasia");
        sList.add("peris");

        /*for(int i=0;i<sList.size();i++){
            if(!sList.get(i).startsWith("L")) {
                System.out.println(sList.get(i));
            }
        }*/

        for(String s : sList){
            System.out.println(s);
        }


        System.out.println("==================");

        Map<String,String> map = new HashMap<>();
        map.put("India","New Delhi");
        map.put("UK","London");
        map.put("USA","Washington");
        map.put("Sri Lanka","Comablo");
        map.put("Bagla Desh","Dhaka");
        map.put("Japan","Tokyo");
        map.put("China","Tokyo");
        map.put("India","Delhi");

        for(Map.Entry<String,String> ent : map.entrySet()){
            System.out.println(ent.getKey() + " ==> " + ent.getValue());
        }

    }

}
