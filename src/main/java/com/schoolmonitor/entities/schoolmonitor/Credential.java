package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The persistent class for the credentials database table.
 * 
 */
//TODO : linkedStudentId and linkedTeacherId could be removed from table and entity
@Entity
@Table(name = "credentials")
@NamedQuery(name = "Credential.findAll", query = "SELECT c FROM Credential c")
public class Credential implements UserDetails {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}