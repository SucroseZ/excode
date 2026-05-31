package com.example.ex5.converter;

import com.example.ex5.dto.StudentDTO;
import com.example.ex5.entity.Student;

public class StudentConverter {
//将 Student 实体转换为 StudentDTO
    public static StudentDTO convertStudent(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }
//将 StudentDTO 转换为 Student 实体
    public static Student convertStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());
        return student;
    }
}
