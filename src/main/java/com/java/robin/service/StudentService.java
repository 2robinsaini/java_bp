package com.java.robin.service;

import com.java.robin.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudentAllList();
    public List<Student> addStudent(Student student);
    public List<Student> removeStudent(Long rollNumber);

}
