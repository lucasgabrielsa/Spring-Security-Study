package com.study.demo.controllers;

import com.study.demo.models.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StudentManagementController {

    private static List<Student> STUDENTS_LIST =
            Arrays.asList(new Student(1, "James Bond"),
                    new Student(2, "Jone Doe"),
                    new Student(3, "James Dean"));



    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ADMIN_TRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS_LIST;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
       System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        System.out.println(String.format("%s %s", studentId, student));
    }

}
