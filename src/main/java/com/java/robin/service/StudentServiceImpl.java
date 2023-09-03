package com.java.robin.service;

import com.java.robin.entity.Address;
import com.java.robin.entity.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService{

    static List<Student> students = new ArrayList<>();

    static {
        students.add(getNewStudent(11l,"Ram"));
    }

    @Override
    public List<Student> getStudentAllList() {
        return students;
    }

    @Override
    public List<Student> addStudent(Student student) {
       students.add(student);
       return students;
    }

    @Override
    public List<Student> removeStudent(Long rollNumber) {
       List<Student> student = students.stream().filter(std -> std.getStdRollNumber().equals(rollNumber)).collect(Collectors.toList());
       students.removeAll(student);
       return students;
    }

    private static Student getNewStudent(Long rollNumber,String name){
        Address address = Address.builder().houseFlatNum(111).floorNumber(10).
                streetOrSociety("Park Avenue").sector("4").city("Noida").state("UP").pin(201301L).build();
        List<String> subjects = Arrays.asList("Mathematics","Physics","Chemistry");
        Student student = Student.builder().stdName(name).stdRollNumber(rollNumber).stdStd(10)
                .address(address).subjects(subjects).build();
        return student;
    }

}
