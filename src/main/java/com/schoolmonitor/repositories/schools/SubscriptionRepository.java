package com.schoolmonitor.repositories.schools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schools.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	Subscription findBySchoolId(int  schoolId);
}
