package com.nuistindo.UniversitySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuistindo.UniversitySystem.model.StudentsModel;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "StudentService")
@Component
public class StudentSOAPService {

    @Autowired
    private StudentsService studentService;

    @WebMethod
    public List<StudentsModel> getStudents() {
        return studentService.getAllStudents();

    }
}
