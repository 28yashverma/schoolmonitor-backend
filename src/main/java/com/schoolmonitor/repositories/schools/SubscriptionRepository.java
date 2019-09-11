package com.schoolmonitor.repositories.schools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schools.Subscription;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {


}
