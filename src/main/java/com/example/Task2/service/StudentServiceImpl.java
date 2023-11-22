package com.example.Task2.service;

import com.example.Task2.entity.Student;
import com.example.Task2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

        @Autowired
        private StudentRepository studentRepository;


    public List<Student> getAllStudents() {
            return studentRepository.findAll();
        }

        public Student getStudentById(int id) {
            return studentRepository.findById(id).get();
        }

        public Student saveStudent(Student student) {
            return studentRepository.save(student);
        }

        public Student updateStudent(int id, Student updatedStudent) {
            Optional<Student> existingStudentOptional = studentRepository.findById(id);

            if (existingStudentOptional.isPresent()) {
                Student existingStudent = existingStudentOptional.get();
                existingStudent.setName(updatedStudent.getName());
                existingStudent.setAge(updatedStudent.getAge());
                existingStudent.setSalary(updatedStudent.getSalary());
                return studentRepository.save(existingStudent);
            } else {

                return null;
            }
        }

        public String deleteStudent(int id) {
            studentRepository.deleteById(id);
            return "Deleted";
        }

}
