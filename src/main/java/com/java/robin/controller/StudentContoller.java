package com.java.robin.controller;

import com.java.robin.entity.Student;
import com.java.robin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "std")
public class StudentContoller {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list",produces = "application/json")
    public List<Student> getStudentList(){
        return studentService.getStudentAllList();
    }

    @PostMapping(value = "/addStudent",consumes = "application/json" ,produces = "application/json")
    public List<Student> addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping(value = "/removeStudent/{rollNumber}" ,produces = "application/json")
    public List<Student> removeStudent(@PathVariable Long rollNumber){
        return studentService.removeStudent(rollNumber);
    }

}
