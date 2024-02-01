package com.example.demo_app.mapper;

import com.example.demo_app.dao.entity.StudentEntity;
import com.example.demo_app.model.enums.StudentStatus;
import com.example.demo_app.model.request.CreateStudentRequest;
import com.example.demo_app.model.response.StudentResponse;

public enum StudentMapper {
    STUDENT_MAPPER;

    public StudentEntity buildStudentEntity(CreateStudentRequest student){
        return StudentEntity.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .status(StudentStatus.ACTIVE)
                .field(student.getField())
                .build();
    }


    public StudentResponse buildStudentResponse(StudentEntity student){
        return StudentResponse.builder()
                .id(student.getId())
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .status(student.getStatus())
                .field(student.getField())
                .build();
    }
}
