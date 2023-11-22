package com.example.Task2.controller;


import com.example.Task2.entity.Student;
import com.example.Task2.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/student")
    public class StudentController {
        @Autowired
        private StudentService studentService;
        
        private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

        @PostMapping("/add")
        public Student addStudent(@RequestBody Student student){
        	logger.info("Student Details Added", student );    	
            return studentService.saveStudent(student);
        }
        @GetMapping("/All")
        public List<Student> GetAll(){
        	logger.info("All Students Details fetched");
            return studentService.getAllStudents();
        }
        @GetMapping("/{id}")
        public Student getById(@PathVariable int id){
        	logger.info("Student Details by Id", id);
            return  studentService.getStudentById(id);
        }
        @PutMapping("/{id}")
        public Student update(@PathVariable int id,@RequestBody Student student){
        	logger.info("Student Details Updated",student);
            return studentService.updateStudent(id,student);
        }
        @DeleteMapping("/{id}")
        public String  delete(@PathVariable int id){
        	logger.info("Student Details Deleted", id);
            return studentService.deleteStudent(id);
        }

    }
