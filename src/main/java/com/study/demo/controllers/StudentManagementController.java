package com.study.demo.controllers;

import com.study.demo.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static List<Student> STUDENTS_LIST =
            Arrays.asList(new Student(1, "James Bond"),
                    new Student(2, "Jone Doe"),
                    new Student(3, "James Dean"));

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS_LIST;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
       System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        System.out.println(String.format("%s %s", studentId, student));
    }

}
