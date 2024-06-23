package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDto;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto findByRollNo(int rollNo);

    List<StudentDto> findAllStudents();

    StudentDto updateSudent(int rollNo, StudentDto studentDto);

    String deleteStudent(int rollNo);

}
