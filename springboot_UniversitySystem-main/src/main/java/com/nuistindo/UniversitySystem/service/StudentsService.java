package com.nuistindo.UniversitySystem.service;

import java.util.List;

import com.nuistindo.UniversitySystem.model.StudentsModel;

public interface StudentsService {

    Iterable<StudentsModel> listAllStudents();

    Iterable<StudentsModel> findAllByOrderByIdAsc();

    StudentsModel findOneStudent(String id);

    StudentsModel registerStudents(String student_id, String name, String gender, String major, String country, String password,Boolean abs);

    void deleteStudent(String id);
    public List<StudentsModel> getAllStudents() ;
    
}
