package com.schoolmonitor.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmonitor.entities.schools.School;
import com.schoolmonitor.entities.schools.Subscription;
import com.schoolmonitor.exception.SchoolMonitorException;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
import com.schoolmonitor.repositories.schools.SchoolRepository;
import com.schoolmonitor.repositories.schools.SubscriptionRepository;
import com.schoolmonitor.security.AuthenticationRequest;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	CredentialsRepository credentialsRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Override
	public boolean Login(AuthenticationRequest authenticationRequest) {
		/*try {
			Date currentDate = new Date();
			School school = schoolRepository.findByDomainForLogin(authenticationRequest.getDomain());
			Subscription subscription = subscriptionRepository.findById(school.getSubscriptionId()).get();
			if (null != subscription && subscription.getSubscribedFrom().compareTo(currentDate) >= 0
					&& subscription.getSubscribedTo().compareTo(currentDate) <= 0) {
				// TODO for NullPointer
			}
		} catch (SchoolMonitorException e) {
			
			e.getLocalizedMessage();
		}*/

		return true;
	}
}
