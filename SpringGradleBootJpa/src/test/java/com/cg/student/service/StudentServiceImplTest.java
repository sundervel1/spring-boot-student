package com.cg.student.service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.student.entities.Student;
import com.cg.student.service.StudentService;
import com.cg.student.service.StudentServiceImpl;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(StudentServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceImplTest {
	@Autowired
	private StudentService service;
	@Autowired
	private EntityManager em;
	
	@Test
	public void testFindById() {
		Student stud = new Student("Sachin", "Gupta", 22);
		em.persist(stud);
		Integer id = stud.getId();
		Student studFound = service.findById(id);
		Assertions.assertEquals(studFound.getFirstName(), "Sachin");		
	}
	@Test
	public void testAddStudent() {
		Student stud = new Student("Deepti", "Tuteja", 21);
		Student studSaved = service.addStudent(stud);
		Assertions.assertEquals(studSaved.getFirstName(), stud.getFirstName());
	}
}
