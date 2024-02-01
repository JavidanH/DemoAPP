package com.example.demo_app.dao.repository;

import com.example.demo_app.dao.entity.StudentEntity;
import com.example.demo_app.model.enums.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    Optional<StudentEntity> findByIdAndStatusNot(Long id, StudentStatus status);
}
