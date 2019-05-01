package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=255)
	private String studentId;

	@Column(nullable=false, length=4)
	private String bloodGroup;

	private int contactNumber;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateOfBirth;

	@Column(nullable=false, length=255)
	private String fatherName;

	@Column(nullable=false, length=255)
	private String firstName;

	@Column(nullable=false, length=255)
	private String lastName;

	@Column(nullable=false, length=255)
	private String motherName;

	@Column(nullable=false)
	private int schoolId;

	@Column(length=255)
	private String stream;

	@Column(length=255)
	private String studentEmailId;

	//bi-directional many-to-one association to Credential
	@OneToMany(mappedBy="student")
	private List<Credential> credentials;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressId", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Schoolspecific
	@ManyToOne
	@JoinColumn(name="schoolSpecificsId", nullable=false)
	private Schoolspecific schoolspecific;

	public Student() {
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
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

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getStream() {
		return this.stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getStudentEmailId() {
		return this.studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public List<Credential> getCredentials() {
		return this.credentials;
	}

	public void setCredentials(List<Credential> credentials) {
		this.credentials = credentials;
	}

	public Credential addCredential(Credential credential) {
		getCredentials().add(credential);
		credential.setStudent(this);

		return credential;
	}

	public Credential removeCredential(Credential credential) {
		getCredentials().remove(credential);
		credential.setStudent(null);

		return credential;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Schoolspecific getSchoolspecific() {
		return this.schoolspecific;
	}

	public void setSchoolspecific(Schoolspecific schoolspecific) {
		this.schoolspecific = schoolspecific;
	}

}