package com.example.Task2;

import com.example.Task2.entity.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
   @Test
    public void testStudent() {
        Student student = new Student(1, "Jaya", 20, 50000.0);

        assertEquals(1, student.getId());
        assertEquals("Jaya", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(50000.0, student.getSalary(), 0.01);
    }
    @Test
    public void testSetters() {
        Student student = new Student(1, "Jaya", 20, 50000.0);

        student.setId(2);
        student.setName("Sri");
        student.setAge(52);
        student.setSalary(70000.0);

        assertEquals(2, student.getId());
        assertEquals("Sri", student.getName());
        assertEquals(52, student.getAge());
        assertEquals(70000.0, student.getSalary(), 0.01);
    }
    
    @Test
    public void testToString() {
        Student student = new Student(1, "Jaya", 20, 50000.0);
 
        assertEquals("Student [id=1, name=Jaya, age=20, salary=50000.0]", student.toString());
    }
}
