package com.schoolmonitor.service;

import org.springframework.stereotype.Service;

import com.schoolmonitor.entities.schools.School;
import com.schoolmonitor.entities.schools.Subscription;
import com.schoolmonitor.model.LoginCredentials;
import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
import com.schoolmonitor.repositories.schools.SchoolRepository;
import com.schoolmonitor.repositories.schools.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	CredentialsRepository credentialsRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;

	public boolean Login(LoginCredentials credentials) {
		School school = schoolRepository.findByDomainForLogin(credentials.getDomain());
		Subscription subscription = subscriptionRepository.findBySchoolId(school.getSchoolId());

		if (null != school && null != subscription) {
			// TODO: set db to point to according to Domain
			if (null != credentialsRepository.findByUserNameAndPassword(credentials.getUserName(),
					credentials.getPassword())) {

			}

		}
		return true;
	}
}
