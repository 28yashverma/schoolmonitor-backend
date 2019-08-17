package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Credential;
@Scope("prototype")
@Repository
public interface CredentialsRepository extends JpaRepository<Credential, Integer> {

	Credential findByUserNameAndPassword(String userName, String password);

	Credential findByUserName(String UserName);
}
