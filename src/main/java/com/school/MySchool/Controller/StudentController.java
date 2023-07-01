package com.school.MySchool.Controller;

import com.school.MySchool.Service.StudentService;
import com.school.MySchool.model.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //save
    @PostMapping("/save")
    ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto studentDto1 = this.studentService.saveStudent(studentDto);
        return new ResponseEntity<StudentDto>(studentDto1, HttpStatus.CREATED);

    }

    //update

    @PutMapping("/update")
    ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto,@PathVariable Integer studentId){

        StudentDto studentDto1 = this.studentService.updateStudent(studentDto, studentId);
        return new ResponseEntity<>(studentDto1,HttpStatus.OK);
    }

    // getStudent
    @GetMapping("/get")
    ResponseEntity<StudentDto> getStudent(@PathVariable Integer studentId){
        StudentDto student = this.studentService.getStudent(studentId);
        return new ResponseEntity<StudentDto>(student,HttpStatus.OK);
    }
    //getAllStudent
    @GetMapping("/getAll")
    ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> allStudent = this.studentService.getAllStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/delete")
    ResponseEntity<String> deleteStudent(@PathVariable Integer studentId){
        this.studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student is deleted successfully",HttpStatus.OK);
    }
}
