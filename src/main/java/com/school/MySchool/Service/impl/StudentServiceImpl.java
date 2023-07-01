package com.school.MySchool.Service.impl;

import com.school.MySchool.Repository.StudentRepository;
import com.school.MySchool.Service.StudentService;
import com.school.MySchool.model.Student;
import com.school.MySchool.model.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    //saveStudent
    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        Student save = this.studentRepository.save(student);
        StudentDto studentDto1 = this.modelMapper.map(save, StudentDto.class);
        return studentDto1;
    }
//updateStudent
    @Override
    public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
        Student student = this.studentRepository.findById(studentId).get();
        student.setStudentName(studentDto.getStudentName());
        student.setStudentAddress(studentDto.getStudentAddress());
        student.setStudentFee(studentDto.getStudentFee());
        student.setSubject(studentDto.getSubject());
        Student updatedstudent = this.studentRepository.save(student);
        StudentDto studentDto1 = this.modelMapper.map(student, StudentDto.class);

        return studentDto1;
    }
//getStudent
    @Override
    public StudentDto getStudent(Integer studentId) {
        Student student = this.studentRepository.findById(studentId).get();
        StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
        return studentDto;
    }
//getAllStudent
    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> studentList = this.studentRepository.findAll();
        List<StudentDto> studentDtos = studentList.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
        return studentDtos;
    }

    //delete
    @Override
    public void deleteStudent(Integer studentId) {
        Student student = this.studentRepository.findById(studentId).get();
       this.studentRepository.delete(student);
    }
}
