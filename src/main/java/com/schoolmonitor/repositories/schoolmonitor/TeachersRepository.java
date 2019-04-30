package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Teacher;
@Repository
public interface TeachersRepository extends JpaRepository<Teacher, String> {

}
