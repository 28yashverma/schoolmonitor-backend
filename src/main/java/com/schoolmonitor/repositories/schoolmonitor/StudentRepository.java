package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Student;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
