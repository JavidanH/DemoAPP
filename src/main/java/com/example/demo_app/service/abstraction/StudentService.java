package com.example.demo_app.service.abstraction;

import com.example.demo_app.dao.repository.StudentRepository;
import com.example.demo_app.model.request.CreateStudentRequest;
import com.example.demo_app.model.response.StudentResponse;

import java.util.List;

public interface StudentService {

    void createStudent(CreateStudentRequest request);

    StudentResponse getStudent(Long id);

    void updateStudentName(Long id,String firstname);

    void deleteStudent(Long id);

    List<StudentResponse> getStudents();
}
