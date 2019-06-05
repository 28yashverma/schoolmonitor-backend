package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=255)
	private String teacherId;

	@Column(nullable=false, length=255)
	private String bloodGroup;

	@Column(length=45)
	private String department;

	@Column(length=45)
	private String designation;

	@Column(nullable=false, length=255)
	private String firstName;

	@Column(nullable=false, length=255)
	private String lastName;

	@Column(nullable=false)
	private int schoolSpecificsId;

	//bi-directional many-to-one association to Credential
	@OneToMany(mappedBy="teacher")
	private List<Credential> credentials;

	public Teacher() {
	}

	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSchoolSpecificsId() {
		return this.schoolSpecificsId;
	}

	public void setSchoolSpecificsId(int schoolSpecificsId) {
		this.schoolSpecificsId = schoolSpecificsId;
	}

	public List<Credential> getCredentials() {
		return this.credentials;
	}

	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}

	public Credential addCredential(Credential credential) {
		getCredentials().add(credential);
		credential.setTeacher(this);

		return credential;
	}

	public Credential removeCredential(Credential credential) {
		getCredentials().remove(credential);
		credential.setTeacher(null);

		return credential;
	}

}