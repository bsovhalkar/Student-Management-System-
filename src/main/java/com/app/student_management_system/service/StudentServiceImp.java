package com.app.student_management_system.service;

import com.app.student_management_system.exception.StudentNotFoundException;
import com.app.student_management_system.model.Student;
import com.app.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Success";
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id,Student student) {
        Student student1 = studentRepository.findById(id).
                orElseThrow(()->
                new  StudentNotFoundException("Student with ID " + id + " not found")
        );
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        studentRepository.save(student1);
        return student1;
    }

    @Override
    public String deleteStudentById(Long id) {

        try {
            studentRepository.deleteById(id);
            return "Success";
        } catch (Exception e) {
            throw new StudentNotFoundException(e.getMessage()+ e.getCause());
        }
    }
}
