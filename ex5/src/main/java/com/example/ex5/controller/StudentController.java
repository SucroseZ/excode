package com.example.ex5.controller;

import com.example.ex5.common.Response;
import com.example.ex5.dto.StudentDTO;
import com.example.ex5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable long id){
        return Response.newSuccess(studentService.getStudentById(id));
    }

    @PostMapping("/student/add")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO){
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudentByID(@PathVariable long id){
        studentService.deleteStudentById(id);
    }

//    @PutMapping("/student/update/{id}")
//    public Response<StudentDTO> updateStudentId(@PathVariable long id, @RequestParam(required = false) String name,
//                                                @RequestParam(required = false) String email){
//        return Response.newSuccess(studentService.updateStudentId(id, name, email));
//
//    }
    @PutMapping("/update/{id}")
    public Response<StudentDTO> updateStudentId(
            @PathVariable long id,
            @RequestBody StudentDTO studentDTO) {
        return Response.newSuccess(studentService.updateStudentId(id, studentDTO.getName(), studentDTO.getEmail()));
    }
}
