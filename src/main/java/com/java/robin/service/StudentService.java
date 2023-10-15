package com.java.robin.service;

import com.java.robin.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> getStudentAllList();
    List<Student> addStudent(Student student);
    List<Student> removeStudent(Long rollNumber);

    List<Student> getStudentListFromStudentMap(Map<Long,Student> rollNumStudentMap);

    List<Student> updateStudent(Student student, Long rollNumber);
}
