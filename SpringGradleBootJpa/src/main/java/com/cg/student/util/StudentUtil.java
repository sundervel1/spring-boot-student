package com.cg.student.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.student.dto.CourseDetails;
import com.cg.student.dto.StudentDetails;
import com.cg.student.entities.Course;
import com.cg.student.entities.Student;

@Component
public class StudentUtil {

	public StudentDetails toDetails(Student stud) {
		Set<Course> courses = stud.getCourses();
		Set<CourseDetails> details = new HashSet<>();
		for (Course course : courses) {
			details.add(new CourseDetails(course));
		}
		StudentDetails studDetails = new StudentDetails(stud.getId(), 
				  stud.getFirstName(), stud.getLastName(), stud.getAge(), details);
		return studDetails;
	}

	public List<StudentDetails> toDetails(List<Student> list) {
		List<StudentDetails> studDetailList = new ArrayList<>();
		for (Student student : list) {
			studDetailList.add(toDetails(student));
		}		
		return studDetailList;
	}

}
