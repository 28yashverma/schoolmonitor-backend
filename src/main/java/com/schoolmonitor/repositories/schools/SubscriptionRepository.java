package com.schoolmonitor.repositories.schools;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schools.Subscription;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {


}
