package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Student;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
