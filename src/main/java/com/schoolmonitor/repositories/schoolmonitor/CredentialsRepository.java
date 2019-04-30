package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Credential;

@Repository
public interface CredentialsRepository extends JpaRepository<Credential, Integer> {

}
