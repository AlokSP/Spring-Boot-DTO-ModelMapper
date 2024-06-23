package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createstudent(@RequestBody StudentDto studentDto) {
        StudentDto createdStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity<StudentDto>(createdStudentDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        List<StudentDto> studentDtoes = studentService.findAllStudents();
        return new ResponseEntity<List<StudentDto>>(studentDtoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentByRollNo(@PathVariable("id") int rollNo) {
        StudentDto studentDto = studentService.findByRollNo(rollNo);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @PutMapping("/{rollNo}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable int rollNo, @RequestBody StudentDto studentDto) {
        StudentDto updatedStudentDto = studentService.updateSudent(rollNo, studentDto);
        return new ResponseEntity<StudentDto>(updatedStudentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNo) {
        String message = studentService.deleteStudent(rollNo);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
