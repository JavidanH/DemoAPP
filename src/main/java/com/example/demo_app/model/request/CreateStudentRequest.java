package com.example.demo_app.model.request;

import com.example.demo_app.model.enums.StudentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {

    private String firstname;

    private String lastname;

    private String field;
}
