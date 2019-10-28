package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Credential;
import com.schoolmonitor.repositories.BaseRepository;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Scope("prototype")
@Repository
public interface CredentialsRepository extends BaseRepository<Credential, Integer> {

	Credential findByUserNameAndPassword(String userName, String password);

	Credential findByUserName(String UserName);
}
