package com.schoolmonitor.entities.schools;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="subscription")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int subscriptionId;

	@Column(unique=true,nullable=false)
	private int schoolId;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date subscribedFrom;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date subscribedTo;

	@Column(nullable=false, length=255)
	private String subscriptionMode;

	public Subscription() {
	}

	public int getSubscriptionId() {
		return this.subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
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

}