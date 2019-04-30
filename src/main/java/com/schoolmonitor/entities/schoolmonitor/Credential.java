package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the credentials database table.
 * 
 */
@Entity
@Table(name="credentials")
@NamedQuery(name="Credential.findAll", query="SELECT c FROM Credential c")
public class Credential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userId;

	private String password;

	private String userName;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="linkedStudentId")
	private Student student;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	@JoinColumn(name="linkedTeacherId")
	private Teacher teacher;

	public Credential() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}