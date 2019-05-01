package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int addressId;

	@Column(length=255)
	private String city;

	@Column(length=255)
	private String landmark;

	@Column(length=255)
	private String pincode;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="address")
	private List<Student> students;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return this.landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setAddress(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setAddress(null);

		return student;
	}

}