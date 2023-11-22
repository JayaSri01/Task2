package com.example.Task2;

import com.example.Task2.entity.Student;
import com.example.Task2.repository.StudentRepository;
import com.example.Task2.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
    public class StudentServiceTest {
        @Mock
        StudentRepository sRepo;
        @InjectMocks
        StudentServiceImpl service;
        @Test
        public void testGetDetails() {
            List<Student> list=new ArrayList<>();
            list.add(new Student(1,"jaya",24,90000));
            list.add(new Student(2,"jasu",24,80000));
            list.add(new Student(3,"veni",24,70000));
            list.add(new Student(4,"bhavani",24,60000));
            when(sRepo.findAll()).thenReturn(list);
            List<Student> userExpected=service.getAllStudents();
            assertEquals(userExpected, list);
        }
        @Test
        public void testAddStudent() {
            Student s=new Student(1,"jaya",25,700000);
            when(sRepo.save(s)).thenReturn(s);
            Student s1=service.saveStudent(s);
            assertEquals(s.getId(), s1.getId());
        }
        @Test
        public void testGetById() {
            Student s=new Student(1,"jaya",25,700000);
            when(sRepo.findById(1)).thenReturn(Optional.of(s));
            Student s1=service.getStudentById(s.getId());
            assertEquals(s.getId(), s1.getId());
        }
        @Test
        public void testUpdate() {
            Student s=new Student(1,"jaya",25,900000);
            Student s1=new Student(2,"sri",26,8000000);
            when(sRepo.findById(1)).thenReturn(Optional.of(s));
            when(sRepo.save(s)).thenReturn(s);
            Student s2=service.updateStudent(1,s1);
            assertEquals(s1.getName(), s2.getName());
        }
        @Test
        public void testDelete() {
            Student s=new Student(2,"sri",25,100000);
            int studentIdToDelete = s.getId();
            String result = service.deleteStudent(studentIdToDelete);
            assertEquals("Deleted",result);
        }

}
