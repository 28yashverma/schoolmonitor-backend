package com.schoolmonitor.entities.schools;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int subscriptionId;

	@Temporal(TemporalType.DATE)
	private Date subscribedFrom;

	@Temporal(TemporalType.DATE)
	private Date subscribedTo;

	private String subscriptionMode;

	//bi-directional many-to-one association to School
	@ManyToOne
	@JoinColumn(name="schoolId")
	private School school;

	public Subscription() {
	}

	public int getSubscriptionId() {
		return this.subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Date getSubscribedFrom() {
		return this.subscribedFrom;
	}

	public void setSubscribedFrom(Date subscribedFrom) {
		this.subscribedFrom = subscribedFrom;
	}

	public Date getSubscribedTo() {
		return this.subscribedTo;
	}

	public void setSubscribedTo(Date subscribedTo) {
		this.subscribedTo = subscribedTo;
	}

	public String getSubscriptionMode() {
		return this.subscriptionMode;
	}

	public void setSubscriptionMode(String subscriptionMode) {
		this.subscriptionMode = subscriptionMode;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}