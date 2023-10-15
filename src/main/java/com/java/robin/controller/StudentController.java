package com.java.robin.controller;

import com.java.robin.entity.Student;
import com.java.robin.service.StudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "std")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list",produces = "application/json")
    public List<Student> getStudentList(){
        logger.info("get student list");
        return studentService.getStudentAllList();
    }

    @PostMapping(value = "/addStudent",consumes = "application/json" ,produces = "application/json")
    public List<Student> addStudent(@RequestBody Student student){
        logger.info("Add student {}",student.getStdName());
        return studentService.addStudent(student);
    }

    @PostMapping(value = "/updateStudent/{rollNumber}",consumes = "application/json" ,produces = "application/json")
    public List<Student> updateStudent(@RequestBody Student student,@PathVariable Long rollNumber){
        logger.info("Update student of name {} and rollNumber {}",student.getStdName(),rollNumber);
        return studentService.updateStudent(student,rollNumber);
    }

    @DeleteMapping(value = "/removeStudent/{rollNumber}" ,produces = "application/json")
    public List<Student> removeStudent(@PathVariable Long rollNumber){
        logger.info("Remove student {}",rollNumber);
        return studentService.removeStudent(rollNumber);
    }

}
