package com.java.concepts;


import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

    public static void main(String[] args) {

        integerStream();
        findFirstAndFindAll();
        flatMapUsage();
        printMapFromList();
        printSortedMap();
        customeClassStramOperation();

    }

    private static void customeClassStramOperation() {

        Employee e1 = Employee.builder().empId(123).name("Axar").salary(20000.0).build();
        Employee e5 = Employee.builder().empId(127).name("Surya").salary(70000.0).build();
        Employee e2 = Employee.builder().empId(124).name("Bumrah").salary(60000.0).build();
        Employee e22 = Employee.builder().empId(124).name("Bumrah").salary(60000.0).build();
        Employee e23 = Employee.builder().empId(124).name("Bumrah").salary(60000.0).build();
        Employee e3 = Employee.builder().empId(125).name("Ishan").salary(50000.0).build();
        Employee e4 = Employee.builder().empId(126).name("Rohit").salary(80000.0).build();
        Employee e6 = Employee.builder().empId(128).name("Virat").salary(80000.0).build();

        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e22);
        empList.add(e23);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        empList.add(e6);

        empList.stream().sorted((emp1,emp2) -> emp1.getSalary().compareTo(emp2.getSalary())).forEach(emp -> System.out.println(emp));
        System.out.println();
        empList.stream().sorted((emp1,emp2) -> emp1.getName().compareTo(emp2.getName())).forEach(emp -> System.out.println(emp));
        System.out.println();
        empList.stream().filter(player -> player.getSalary() > 50000).forEach(emp -> System.out.println(emp));

        System.out.println("Unique Employee 1");
        empList.stream().distinct().forEach(emp -> System.out.println(emp));

    }

    private static void integerStream() {

        Stream integerStream = Stream.of(1, 2, 3, 77, 6, 5,-5,100,25);
        Stream integerStream2 = Stream.of(1, 2, 3, 77, 6, 5,-5,100,25);
        Stream integerStream3 = Stream.of(1, 2, 3, 77, 6, 5,-5,100,25,3,4,5,3,4,5,6,2,3,4,5,6,2,3,4,4,5);
        Stream integerStream4 = Stream.of(1, 2, 3, 77, 6, 5,-5,100,25,3,4,5,3,4,5,6,2,3,4,5,6,2,3,4,4,5);
        int max = (int)integerStream.max( (a,b) -> (int)a -(int)b ).get();
        int min = (int)integerStream2.min( (a,b) -> (int)a -(int)b ).get();
        System.out.println(max + " " + min);
        integerStream3.forEach(i -> System.out.print(i + " "));
        System.out.println();
        integerStream4.distinct().sorted().forEach(i -> System.out.print(i + " "));

        System.out.println();

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        System.out.println("-------- Random ends----");

        Stream integerStream5 = Stream.of(1, 2, 3, 77, 6, 5,-5,100,25);
        integerStream5.map(i -> (int)i*2).forEach(System.out::println);


        //Concat of stream
        List<Integer> integerList1 = Arrays.asList(1,2,3,4);
        List<Integer> integerList2 = Arrays.asList(5,6,7);
        Stream<Integer> concatStream = Stream.concat(integerList1.stream(), integerList2.stream());
        concatStream.forEach(System.out::print);
        int sum = integerList1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of list: " + sum);
    }

    private static void findFirstAndFindAll() {
        List<String> countryList = new ArrayList<>();
        countryList.add("INDIA");
        countryList.add("America");
        countryList.add("England");
        countryList.add("SRI LANKA");
        countryList.add("SINGAPORE");
        countryList.add("ITALY");

        System.out.println("Find First");
        countryList.stream().findFirst().stream().forEach(data -> System.out.println(data));
        System.out.println(countryList.stream().findFirst().orElse(null));
        System.out.println(countryList.parallelStream().findFirst().orElse(null));
        System.out.println(countryList.stream().findAny().orElse(null));

        //limit example
        countryList.stream().limit(3).forEach(data -> System.out.print(data+" "));
        System.out.println();
    }

    private static void flatMapUsage() {

        List<String> satyug = Arrays.asList("HrishChandra","Vishwamitra");
        List<String> tretayug = Arrays.asList("Shri Ram","Shri Hanuman","Bhagwan Parshuram","Lakshman","Mata Sita");
        List<String> dwaparyug = Arrays.asList("Shri Krishna","Bhagwan Parshuram");
        List<String> kalyug = Arrays.asList("Bhagwan Kalki");
        List<List<String>> allGodOrGodess = new ArrayList<>();
        allGodOrGodess.add(satyug);
        allGodOrGodess.add(tretayug);
        allGodOrGodess.add(dwaparyug);
        allGodOrGodess.add(kalyug);
        allGodOrGodess.stream().flatMap( myGod -> myGod.stream()).forEach(myGod -> System.out.println(myGod));
        List<String> allYugName = Arrays.asList("Satyug","TretaYug","DwaparYug","Kalyug");
        AtomicInteger i = new AtomicInteger(0);
        System.out.println();
        Map<String,List<String>> dataMap = allGodOrGodess.stream().collect(Collectors.toMap(k -> allYugName.get(i.getAndIncrement()),v -> v));
        dataMap.entrySet().stream().forEach(country -> System.out.println(country.getKey() + " -- " + country.getValue()));

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
