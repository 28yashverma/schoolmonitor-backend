package com.schoolmonitor.entities.schoolmonitor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the credentials database table.
 * 
 */
@Entity
@Table(name="credentials")
@NamedQuery(name="Credential.findAll", query="SELECT c FROM Credential c")
public class Credential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date accountCreationDate;

	@Column(nullable=false)
	private byte isActive;

	@Column(nullable=false)
	private byte isAdmin;

	@Column(length=255)
	private String linkedStudentId;

	@Column(length=255)
	private String linkedTeacherId;

	private int numberOfRetry;

	@Column(nullable=false, length=255)
	private String password;

	@Temporal(TemporalType.DATE)
	private Date passwordLastChangedDate;

	@Column(nullable=false, length=255)
	private String userName;

	//bi-directional many-to-one association to Rolesmapping
	@OneToMany(mappedBy="credential")
	private List<Rolesmapping> rolesmappings;

	public Credential() {
	}

	public Date getAccountCreationDate() {
		return this.accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLinkedStudentId() {
		return this.linkedStudentId;
	}

	public void setLinkedStudentId(String linkedStudentId) {
		this.linkedStudentId = linkedStudentId;
	}

	public String getLinkedTeacherId() {
		return this.linkedTeacherId;
	}

	public void setLinkedTeacherId(String linkedTeacherId) {
		this.linkedTeacherId = linkedTeacherId;
	}

	public int getNumberOfRetry() {
		return this.numberOfRetry;
	}

	public void setNumberOfRetry(int numberOfRetry) {
		this.numberOfRetry = numberOfRetry;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordLastChangedDate() {
		return this.passwordLastChangedDate;
	}

	public void setPasswordLastChangedDate(Date passwordLastChangedDate) {
		this.passwordLastChangedDate = passwordLastChangedDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Rolesmapping> getRolesmappings() {
		return this.rolesmappings;
	}

	public void setRolesmappings(List<Rolesmapping> rolesmappings) {
		this.rolesmappings = rolesmappings;
	}

	public Rolesmapping addRolesmapping(Rolesmapping rolesmapping) {
		getRolesmappings().add(rolesmapping);
		rolesmapping.setCredential(this);

		return rolesmapping;
	}

	public Rolesmapping removeRolesmapping(Rolesmapping rolesmapping) {
		getRolesmappings().remove(rolesmapping);
		rolesmapping.setCredential(null);

		return rolesmapping;
	}

}