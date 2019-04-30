package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Schoolspecific;

@Repository
public interface SchoolSpecificesRepository extends JpaRepository<Schoolspecific, Integer> {

}
