package com.app.student_management_system.service;


import com.app.student_management_system.model.Student;
import com.app.student_management_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface StudentService {
//    StudentRepository studentRepository;
    public String createStudent(Student student);
    public Student getStudentById(Long id);

    public List<Student> getAllStudents();

    public Student updateStudent(Long id,Student student);
    public String deleteStudentById(Long id);


}
