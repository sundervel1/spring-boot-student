package com.cg.student.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double fee;
	@ManyToOne
	@JoinColumn(name = "stud_id")
	private Student student;
	@ElementCollection
	@MapKeyColumn(name = "author")
	@Column(name = "value")
	@CollectionTable(name = "books",joinColumns = @JoinColumn(name="course_id"))
	private Map<String, String> books = new HashMap<>();
	public Course() {
		books.put("Joahua", "Effective Java");
		books.put("Kathy", "Head First java");
		books.put("Alan", "Java 8 in action");
		books.put("Bruce", "Thinking in Java");
	}
	public Course(int id, String name, double fee) {
		this();
		this.id = id;
		this.name = name;
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee +  "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
