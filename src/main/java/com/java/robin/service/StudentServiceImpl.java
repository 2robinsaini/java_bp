package com.java.robin.service;

import com.java.robin.config.StudentException;
import com.java.robin.entity.Address;
import com.java.robin.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService{

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    static Map<Long,Student> students = new HashMap<>();

    static {
        students.put(11l,getNewStudent(11l,"Ram"));
    }

    @Override
    public List<Student> getStudentAllList() {
        return students.entrySet().stream().map(stdEntry -> stdEntry.getValue()).collect(Collectors.toList());
    }

    @Override
    public List<Student> addStudent(Student student) {
       students.put(student.getStdRollNumber(), student);
       return getStudentListFromStudentMap(students);
    }

    @Override
    public List<Student> removeStudent(Long rollNumber) {
        if(students.containsKey(rollNumber)){
            logger.info("Roll number {} is present in available students list",rollNumber);
            students.remove(rollNumber);
            logger.info("student removed");
            return getStudentListFromStudentMap(students);
        }
        else{
            logger.error("Roll number {} is NOT present in available students list",rollNumber);
            throw new StudentException("Roll number "+ rollNumber +"is NOT present in available students list");
        }
    }

    @Override
    public List<Student> getStudentListFromStudentMap(Map<Long, Student> rollNumStudentMap) {
        return rollNumStudentMap.entrySet().stream().map(stdEntry -> stdEntry.getValue()).collect(Collectors.toList());
    }

    @Override
    public List<Student> updateStudent(Student student, Long rollNumber) {
        Student studentOld = students.get(rollNumber);
        students.put(rollNumber,student);
        String difference = compareOldAndNewStudent(studentOld,student);
        logger.info(difference);
        return getStudentListFromStudentMap(students);
    }

    private String compareOldAndNewStudent(Student studentOld, Student student) {
         StringJoiner stringJoiner = new StringJoiner(",","[","]");
        try {
            matchField(studentOld.getStdName(), student.getStdName(), "Name", stringJoiner);
            matchField(studentOld.getStdStd(), student.getStdStd(), "Std", stringJoiner);
            matchField(studentOld.getSubjects(), student.getSubjects(), "Subject", stringJoiner);
            matchField(studentOld.getAddress().getCity(), student.getAddress().getCity(), "City", stringJoiner);
            matchField(studentOld.getAddress().getState(), student.getAddress().getState(), "State", stringJoiner);
            matchField(studentOld.getAddress().getHouseFlatNum(), student.getAddress().getHouseFlatNum(), "House/Flat", stringJoiner);
            matchField(studentOld.getAddress().getPin(), student.getAddress().getPin(), "Pin", stringJoiner);
            matchField(studentOld.getAddress().getCity(), student.getAddress().getCity(), "City", stringJoiner);
        }
        catch (NullPointerException ex){
            logger.error(ex.getStackTrace().toString());
            throw new StudentException(ex.getMessage());
        }
        return stringJoiner.toString();
    }

    private void matchField(String oldValue,String newValue,String filedName,StringJoiner stringJoiner){
        if(!oldValue.equalsIgnoreCase(newValue)){
            stringJoiner.add(filedName + " changed from "+ oldValue + " to " + newValue);
        }
    }

    private void matchField(Long oldValue,Long newValue,String filedName,StringJoiner stringJoiner){
        if(oldValue!=newValue){
            stringJoiner.add(filedName + " changed from "+ oldValue + " to " + newValue);
        }
    }

    private void matchField(Integer oldValue,Integer newValue,String filedName,StringJoiner stringJoiner){
        if(oldValue!=newValue){
            stringJoiner.add(filedName + " changed from "+ oldValue + " to " + newValue);
        }
    }

    private void matchField(List<String> oldValue,List<String> newValue,String filedName,StringJoiner stringJoiner){
        if(!oldValue.containsAll(newValue) && newValue.containsAll(oldValue)){
            stringJoiner.add(filedName + " changed from "+ oldValue + " to " + newValue);
        }
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
