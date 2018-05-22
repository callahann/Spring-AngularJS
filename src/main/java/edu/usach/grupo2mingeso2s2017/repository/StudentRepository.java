package edu.usach.grupo2mingeso2s2017.repository;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import edu.usach.grupo2mingeso2s2017.entities.Student;
import edu.usach.grupo2mingeso2s2017.entities.Section;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>{
	List<Student> findByemail(String email);

	@Query (value = "SELECT * FROM student WHERE student.email LIKE CONCAT(:email,'%')",
		nativeQuery=true)
		Student findStudenByEmail(@Param("email") String email);

	Iterable<Student> findBySection(Section section);
}
