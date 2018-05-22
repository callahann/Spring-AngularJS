package edu.usach.grupo2mingeso2s2017.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.usach.grupo2mingeso2s2017.entities.Teacher;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Integer> {
	List<Teacher> findByemail(String email);
	@Query (value = "SELECT * FROM teacher WHERE teacher.email LIKE CONCAT(:email,'%')",
			nativeQuery=true)
			Teacher findTeacherByEmail(@Param("email") String email);
}
