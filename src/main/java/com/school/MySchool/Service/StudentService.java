package com.school.MySchool.Service;

import com.school.MySchool.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    //save Student
    StudentDto saveStudent(StudentDto studentDto);

    //update Student
    StudentDto updateStudent(StudentDto studentDto,Integer studentId);

    // get Student

    StudentDto getStudent(Integer studentId);

    // getAllStudent

    List<StudentDto> getAllStudent();


    // deleteStudent

    void deleteStudent(Integer studentId);
}
