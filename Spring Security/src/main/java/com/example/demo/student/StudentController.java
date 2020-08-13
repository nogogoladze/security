package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1,"Nodar Gogoladze"),
            new Student(2,"Nika Kakauridze")
    );


    @GetMapping(path = "{stidentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) throws IllegalAccessException {
        return students.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalAccessException("Student "+ studentId + "is incorrect"));

    }

}
