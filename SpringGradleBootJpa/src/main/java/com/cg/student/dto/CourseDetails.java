package com.cg.student.dto;

import com.cg.student.entities.Course;

public class CourseDetails {
	private int id;
	private String name;
	private double fee;
	public CourseDetails() {
	}
	public CourseDetails(int id, String name, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
	}
	public CourseDetails(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.fee = course.getFee();
	}
	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", name=" + name + ", fee=" + fee + "]";
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
	
}
