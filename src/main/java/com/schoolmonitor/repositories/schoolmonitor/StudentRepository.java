package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Student;
import com.schoolmonitor.repositories.BaseRepository;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface StudentRepository extends BaseRepository<Student, String> {
	Integer findStudentIdBySchoolId( Integer schoolId);
}
