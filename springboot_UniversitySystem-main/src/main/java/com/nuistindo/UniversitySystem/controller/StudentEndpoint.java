package com.nuistindo.UniversitySystem.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.w3c.dom.Element;

import com.nuistindo.UniversitySystem.model.GetStudentResponse;
import com.nuistindo.UniversitySystem.model.StudentsModel;
import com.nuistindo.UniversitySystem.service.StudentsService;

@Endpoint
public class StudentEndpoint {
    private static final String NAMESPACE_URI = "http://nuistindo.com/management";
    
    @Autowired
    private StudentsService service;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload Element requestElement) {
        GetStudentResponse response = new GetStudentResponse();

        List<StudentsModel> students = service.getAllStudents();

        response.getStudents().addAll(students);

        return response;
    }

}
