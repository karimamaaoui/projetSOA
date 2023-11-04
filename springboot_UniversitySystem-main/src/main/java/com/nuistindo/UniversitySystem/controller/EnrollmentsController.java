package com.nuistindo.UniversitySystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nuistindo.UniversitySystem.model.CoursesModel;
import com.nuistindo.UniversitySystem.model.EnrollmentsModel;
import com.nuistindo.UniversitySystem.model.StudentsModel;
import com.nuistindo.UniversitySystem.repository.EnrollmentsRepository;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentsController {

    private final EnrollmentsRepository enrollmentsRepository;

    public EnrollmentsController(EnrollmentsRepository enrollmentsRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
    }

    @PostMapping("/add")
    public String addEnrollment(@RequestParam CoursesModel course_id, @RequestParam StudentsModel student_id) {
        EnrollmentsModel enrollment = new EnrollmentsModel();
        enrollment.setCourse_id(course_id);
        enrollment.setStudent_id(student_id);

        enrollmentsRepository.save(enrollment);

        return "redirect:/absenteeism_statistics";
    }
}
