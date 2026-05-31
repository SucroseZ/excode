package com.example.ex5.service;

import com.example.ex5.converter.StudentConverter;
import com.example.ex5.dto.StudentDTO;
import com.example.ex5.entity.Student;
import com.example.ex5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service //标识该类为 Service 层
public class StudentServiceImpl implements StudentService {
    @Autowired //Spring 会自动注入 UserRepository 的实现
    public StudentRepository studentRepository;

    @Override  // 标明是实现接口方法
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        // 判断email的唯一性
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        // 如果通过查询得到的结果非空
        if(!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email:"+studentDTO.getEmail()+" has been taken!");
        }
        // 由于现在为StudentDTO对象，需要将其转换为一个Student对象
        Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        // 判断id是都在表中
        studentRepository.findById(id).orElseThrow(()->new IllegalStateException("id:"+id+"doesn't exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentId(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("id" + id+ "doesn't exist!"));
        if(StringUtils.hasLength(name) && !studentInDB.getName().equals(name)){
            studentInDB.setName(name);
        }
        if(StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }
}
