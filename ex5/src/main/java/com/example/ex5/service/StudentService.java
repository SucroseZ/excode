package com.example.ex5.service;

import com.example.ex5.dto.StudentDTO;

public interface StudentService {
    StudentDTO getStudentById(long id);
    Long addNewStudent(StudentDTO studentDTO);
    void deleteStudentById(long id);
    StudentDTO updateStudentId(long id, String name, String email);
}


