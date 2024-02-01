package com.example.demo_app.service.concrete;

import com.example.demo_app.dao.entity.StudentEntity;
import com.example.demo_app.dao.repository.StudentRepository;
import com.example.demo_app.exception.NotFoundException;
import com.example.demo_app.model.enums.StudentStatus;
import com.example.demo_app.model.request.CreateStudentRequest;
import com.example.demo_app.model.response.StudentResponse;
import com.example.demo_app.service.abstraction.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo_app.mapper.StudentMapper.STUDENT_MAPPER;
import static com.example.demo_app.model.enums.StudentStatus.DELETED;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceHandler implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void createStudent(CreateStudentRequest request) {
        log.info("ActionLog.createStudent.start request:{}", request);
        studentRepository.save(STUDENT_MAPPER.buildStudentEntity(request));
        log.info("ActionLog.createStudent.success request:{}", request);
    }

    @Override
    public StudentResponse getStudent(Long id) {
        var student = fetchStudentIfExist(id);
        return STUDENT_MAPPER.buildStudentResponse(student);
    }

    @Override
    public void updateStudentName(Long id,String firstname) {
        var student =fetchStudentIfExist(id);
        student.setFirstname(firstname);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        var student = fetchStudentIfExist(id);
        student.setStatus(DELETED);
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> getStudents() {
        return studentRepository.findAll().stream()
                .map(STUDENT_MAPPER::buildStudentResponse)
                .collect(Collectors.toList());
    }

    private StudentEntity fetchStudentIfExist(Long id){
        return studentRepository.findByIdAndStatusNot(id, DELETED)
                .orElseThrow(() -> new NotFoundException("Student not found"));
    }
}
