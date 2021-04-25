package com.cg.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.student.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	List<Student> findByFirstName(String name);
	
	@Query("from Student where firstName=:fname and lastName=:lname")
	List<Student> findByFullName(@Param("fname") String firstName, 
			@Param("lname")String lastName);
}
