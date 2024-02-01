package com.example.demo_app.dao.entity;

import com.example.demo_app.model.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    private String field;

}
