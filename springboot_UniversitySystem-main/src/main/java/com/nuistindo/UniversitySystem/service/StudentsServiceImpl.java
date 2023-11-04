package com.nuistindo.UniversitySystem.service;

import com.nuistindo.UniversitySystem.model.EnrollmentsModel;
import com.nuistindo.UniversitySystem.model.StudentsModel;
import com.nuistindo.UniversitySystem.repository.EnrollmentsRepository;
import com.nuistindo.UniversitySystem.repository.StudentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class StudentsServiceImpl implements StudentsService{

    private final StudentsRepository studentsRepository;
    @Autowired
    private EnrollmentsRepository enrollmentRepository;

    
    public StudentsServiceImpl(StudentsRepository studentsRepository) { this.studentsRepository = studentsRepository; }

    public Iterable<StudentsModel> listAllStudents() { return studentsRepository.findAll(); }

    public Iterable<StudentsModel> findAllByOrderByIdAsc() { return studentsRepository.findAllByOrderByIdAsc(); }

    public StudentsModel findOneStudent(String id) {
        return studentsRepository.findOneById(id).orElse(null);
    }

    public StudentsModel registerStudents(String student_id, String name, String gender ,String major, String country, String password,Boolean absent) {
        if (student_id == null || name == null) {
            return null;
        } else {
            StudentsModel student = new StudentsModel();
            student.setId(student_id);
            student.setName(name);
            student.setGender(gender);
            student.setMajor(major);
            student.setCountry(country);
            student.setPassword(password);
            student.setIsAbsent(absent);
            return studentsRepository.save(student);
        }
    }

    public StudentsModel updateStudent(String id, String name, String major, String country,Boolean absent) {
        if (id == null || name == null) {
            return null;
        } else {
            StudentsModel student = studentsRepository.findOneById(id).orElse(null);
            student.setId(id);
            student.setName(name);
            student.setMajor(major);
            student.setCountry(country);
            student.setIsAbsent(absent);
            return studentsRepository.save(student);
        }
    }

    @Transactional
    public void deleteStudent(String id) {

        studentsRepository.removeById(id);
    }
    
    public double calculateAbsenteeismRate(String id) {
        StudentsModel student = studentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id " + id));

        int totalAbsences = studentsRepository.countByIsAbsentIsTrueAndId(id);

          int totalCoursesScheduled = enrollmentRepository.countEnrollmentsByStudentId(id);

        if (totalCoursesScheduled > 0) {
            return (totalAbsences * 100.0) / totalCoursesScheduled;
        } else {
            return 0.0; 
        }
        
    }

    public List<StudentsModel> getAllStudents() {
        return studentsRepository.findAll();
    }
	

}
