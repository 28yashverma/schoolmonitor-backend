package com.schoolmonitor.repositories.schools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schools.School;
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

}
