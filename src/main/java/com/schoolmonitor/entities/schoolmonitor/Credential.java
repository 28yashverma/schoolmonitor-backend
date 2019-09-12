package com.schoolmonitor.entities.schoolmonitor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the credentials database table.
 * 
 */
// TODO : linkedStudentId and linkedTeacherId could be removed from table and entity
@Entity
@Table(name = "credentials")
@NamedQuery(name = "Credential.findAll", query = "SELECT c FROM Credential c")
public class Credential  {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private byte isAdmin;

	@Column(nullable = false, length = 255)
	private String password;
	@Id
	@Column(nullable = false)
	private int userId;

	@Column(nullable = false, length = 255)
	private String userName;

	@Column(length = 45)
	private String linkedStudentId;

	@Column(length = 45)
	private String linkedTeacherId;
	
	@Column(nullable=false)
	private Date accountCreationDate;
	
	@Column(nullable=true)
	private Date passwordLastChangedDate;
	
	@Column
	private int numberOfRetry;
	
	@Column(nullable=false)
    private byte isActive;
	
	
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public Date getPasswordLastChangedDate() {
		return passwordLastChangedDate;
	}

	public void setPasswordLastChangedDate(Date passwordLastChangedDate) {
		this.passwordLastChangedDate = passwordLastChangedDate;
	}

	public int getNumberOfRetry() {
		return numberOfRetry;
	}

	public void setNumberOfRetry(int numberOfRetry) {
		this.numberOfRetry = numberOfRetry;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	
	public String getLinkedStudentId() {
		return linkedStudentId;
	}

	public void setLinkedStudentId(String linkedStudentId) {
		this.linkedStudentId = linkedStudentId;
	}

	public String getLinkedTeacherId() {
		return linkedTeacherId;
	}

	public void setLinkedTeacherId(String linkedTeacherId) {
		this.linkedTeacherId = linkedTeacherId;
	}

	// bi-directional one-to-one association to Student
	@OneToOne(mappedBy = "credential", fetch = FetchType.LAZY)
	private Student student;

	// bi-directional one-to-one association to Teacher
	@OneToOne(mappedBy = "credential", fetch = FetchType.LAZY)
	private Teacher teacher;

	public Credential() {
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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