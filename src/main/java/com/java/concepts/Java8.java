package com.java.concepts;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8 {

    public static void main(String[] args) {

        printMapFromList();
        printSortedMap();


    }

    private static void printMapFromList() {
        List<String> countryList = new ArrayList<>();
        countryList.add("INDIA");
        countryList.add("USA");
        countryList.add("UK");
        countryList.add("SRI LANKA");
        countryList.add("SINGAPORE");
        countryList.add("ITLY");

        Map<String,Integer> dataMap = countryList.stream().collect(Collectors.toMap(k -> k, v -> v.length()));
        System.out.println();
        dataMap.entrySet().stream().forEach(country -> System.out.println(country.getKey() + " -- " + country.getValue()));

    }

    private static void printSortedMap() {

        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("India","New Delhi");
        dataMap.put("Japan","Tokyo");
        dataMap.put("America","Washington");
        dataMap.put("England","London");
        dataMap.put("Zimbabwe","Harare");
        dataMap.put("Afghanistan","Kabul");
        dataMap.put("Sri Lanka","Colombo");

        dataMap.entrySet().stream().forEach(country -> System.out.println(country.getKey() + " -- " + country.getValue()));
        System.out.println();
        dataMap.entrySet().stream().sorted( (c1,c2) -> c1.getKey().compareTo(c2.getKey())).
                forEach(country -> System.out.println(country.getKey() + " -- " + country.getValue()));
        System.out.println();
        dataMap.entrySet().stream().sorted( (c1,c2) -> c1.getValue().compareTo(c2.getValue())).
                forEach(country -> System.out.println(country.getKey() + " -- " + country.getValue()));

    }


}
