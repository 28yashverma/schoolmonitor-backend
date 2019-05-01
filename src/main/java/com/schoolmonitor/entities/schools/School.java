package com.schoolmonitor.entities.schools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the school database table.
 * 
 */
@Entity
@Table(name="school")
@NamedQuery(name="School.findAll", query="SELECT s FROM School s")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int schoolId;

	@Column(nullable=false, length=255)
	private String domainForLogin;

	@Column(nullable=false, length=255)
	private String schoolName;

	public School() {
	}

	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getDomainForLogin() {
		return this.domainForLogin;
	}

	public void setDomainForLogin(String domainForLogin) {
		this.domainForLogin = domainForLogin;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}