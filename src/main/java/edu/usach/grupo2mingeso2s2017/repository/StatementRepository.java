package edu.usach.grupo2mingeso2s2017.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.usach.grupo2mingeso2s2017.entities.Statement;
import edu.usach.grupo2mingeso2s2017.entities.Teacher;

public interface StatementRepository extends PagingAndSortingRepository<Statement, Integer>{
	List<Statement> findByteacher(Teacher teacher);

	@Query (value = "SELECT * FROM student, statement, code WHERE student.id_student = :idStudent AND student.id_student = code.id_student AND code.id_statement = statement.id_statement",
			nativeQuery=true)
	Iterable<Statement> findByStudent(@Param("idStudent") Integer idStudent);

}
