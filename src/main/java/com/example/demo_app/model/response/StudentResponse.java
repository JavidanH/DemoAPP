package com.example.demo_app.model.response;

import com.example.demo_app.model.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private StudentStatus status;
    private String field;
}
