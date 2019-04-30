package com.schoolmonitor.entities.schools;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the school database table.
 * 
 */
@Entity
@NamedQuery(name="School.findAll", query="SELECT s FROM School s")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int schoolId;

	private String domainForLogin;

	private String schoolName;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="school")
	private List<Subscription> subscriptions;

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

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setSchool(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setSchool(null);

		return subscription;
	}

}