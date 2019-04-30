package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
