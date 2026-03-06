package com.app.student_management_system.controller;


import com.app.student_management_system.exception.StudentNotFoundException;
import com.app.student_management_system.model.Student;
import com.app.student_management_system.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
public class StudentController {
    @Autowired
     StudentServiceImp studentServiceImp;
    public StudentController(StudentServiceImp studentServiceImp) {}
    public StudentController() {}

    @GetMapping("/")
    public List<Student> findAll() {
//        studentServiceImp.getAllStudents();
        return studentServiceImp.getAllStudents();
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {
        studentServiceImp.createStudent(student);
        return student;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try{
            Student student = studentServiceImp.getStudentById(id);
            return ResponseEntity.ok(student);
        }
        catch(StudentNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try{
            studentServiceImp.updateStudent(id, student);
        }
        catch(StudentNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        try{
            studentServiceImp.deleteStudentById(id);
        }
        catch(StudentNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok("Student with ID " + id + " was deleted");
    }

}
