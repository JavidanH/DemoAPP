package com.example.demo_app.controller;


import com.example.demo_app.model.request.CreateStudentRequest;
import com.example.demo_app.model.response.StudentResponse;
import com.example.demo_app.service.abstraction.StudentService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  createStudent (@RequestBody
                                CreateStudentRequest request){
        studentService.createStudent(request);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Long id){

        return studentService.getStudent(id);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentName(@PathVariable Long id,
                                  @RequestParam String firstname){
        studentService.updateStudentName(id, firstname);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
