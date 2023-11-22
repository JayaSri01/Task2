package com.example.Task2.service;

import com.example.Task2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student saveStudent(Student student);
    public Student updateStudent(int id, Student updatedStudent);
    public String deleteStudent(int id);




}
