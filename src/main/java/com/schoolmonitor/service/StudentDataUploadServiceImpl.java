
package com.schoolmonitor.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.schoolmonitor.repositories.schoolmonitor.CredentialsRepository;
import com.schoolmonitor.repositories.schools.SchoolRepository;
import com.schoolmonitor.repositories.schools.SubscriptionRepository;

/**
 * @author PrabhjeetS
 * @version 1.0 Dec 28, 2019
 */
@Service
public class StudentDataUploadServiceImpl implements StudentDataUploadService {
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	CredentialsRepository credentialsRepository;
	private static final String FILE_DIRECTORY = "/var/files";
	@Override
	public Void studentDataUpload(MultipartFile studentDataFile) throws IOException {
		//Path filePath = Paths.get(/*FILE_DIRECTORY + "/" +*/ studentDataFile.getOriginalFilename());
		//Files.copy(studentDataFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		

		/*if(credentialsRepository.findByUserName(principal.getName()).getIsAdmin()==1) {
		int subscriptionId;
		String loggedInDomain = TenantContext.getCurrentTenant();
		School school = schoolRepository.findByDomainForLogin(loggedInDomain);
		if (null != school) {
			subscriptionId = school.getSubscriptionId();
			Subscription subscription = subscriptionRepository.findById(subscriptionId).get();
			if (subscription.getSubscriptionStatus().equalsIgnoreCase("NEW")) {
				subscription.setSubscriptionStatus("CONTINUED");
				File loggedInAdminFolder=new File("/schoolmonitor-backend/src/main/resources"+loggedInDomain+"_"+principal.getName());
				if(!loggedInAdminFolder.exists()) {
					loggedInAdminFolder.mkdir();
					File fileToUpload=new File();
					}
			} else {

			}
		}
		}

*/		return null;
	}

}
