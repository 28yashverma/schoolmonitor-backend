package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Student;
import com.schoolmonitor.repositories.BaseRepository;
/**
 * @author PrabhjeetS
 * @version 1.0
 */
@Repository
public interface StudentRepository extends BaseRepository<Student, String> {
	@Query("select s.studentId from Student s where s.schoolId=?1")
	Integer findStudentIdBySchoolId( Integer schoolId);

	
}
