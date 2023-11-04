package com.nuistindo.UniversitySystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "enrollments_table")
public class EnrollmentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
  
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesModel course_id;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentsModel student_id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    public CoursesModel getCourse_id() {
		return course_id;
	}

	public void setCourse_id(CoursesModel course_id) {
		this.course_id = course_id;
	}

	public StudentsModel getStudent_id() {
		return student_id;
	}

	public void setStudent_id(StudentsModel student_id) {
		this.student_id = student_id;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentsModel that = (EnrollmentsModel) o;
        return id == that.id && Objects.equals(course_id, that.course_id) && Objects.equals(student_id, that.student_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course_id, student_id);
    }

    @Override
    public String toString() {
        return "EnrollmentsModel{" +
                "id=" + id +
                ", course_id='" + course_id + '\'' +
                ", student_id='" + student_id + '\'' +
                '}';
    }
}
