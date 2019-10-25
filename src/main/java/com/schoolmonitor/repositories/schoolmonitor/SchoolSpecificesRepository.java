package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Schoolspecific;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface SchoolSpecificesRepository extends CrudRepository<Schoolspecific, Integer> {

}
