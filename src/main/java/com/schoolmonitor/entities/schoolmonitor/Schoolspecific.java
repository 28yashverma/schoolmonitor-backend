package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the schoolspecifics database table.
 * 
 */
@Entity
@Table(name="schoolspecifics")
@NamedQuery(name="Schoolspecific.findAll", query="SELECT s FROM Schoolspecific s")
public class Schoolspecific implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int schoolSpecificsId;

	@Column(length=255)
	private String branchName;

	@Column(nullable=false, length=255)
	private String district;

	@Column(nullable=false, length=255)
	private String pincode;

	@Column(nullable=false, length=255)
	private String schoolAddress;

	@Column(nullable=false)
	private int schoolContactNumber;

	@Column(length=255)
	private String schoolEmailId;

	public Schoolspecific() {
	}

	public int getSchoolSpecificsId() {
		return this.schoolSpecificsId;
	}

	public void setSchoolSpecificsId(int schoolSpecificsId) {
		this.schoolSpecificsId = schoolSpecificsId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getSchoolAddress() {
		return this.schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public int getSchoolContactNumber() {
		return this.schoolContactNumber;
	}

	public void setSchoolContactNumber(int schoolContactNumber) {
		this.schoolContactNumber = schoolContactNumber;
	}

	public String getSchoolEmailId() {
		return this.schoolEmailId;
	}

	public void setSchoolEmailId(String schoolEmailId) {
		this.schoolEmailId = schoolEmailId;
	}

}