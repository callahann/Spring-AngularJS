package edu.usach.grupo2mingeso2s2017;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.usach.grupo2mingeso2s2017.entities.Statement;
import edu.usach.grupo2mingeso2s2017.entities.Teacher;
import edu.usach.grupo2mingeso2s2017.repository.StatementRepository;
import edu.usach.grupo2mingeso2s2017.repository.TeacherRepository;

import static org.junit.Assert.assertEquals;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatementTest {
	@Autowired
	TeacherRepository teacherRepo;
	
	@Autowired
	StatementRepository statementRepo;
	
	
	@Test
	public void testLoadStatements()
	{
		List<Statement> statements = (ArrayList<Statement>)statementRepo.findAll();
		long count= statementRepo.count();
		assertEquals("Didn't get all statments", count, statements.size());
	}
	@Test
	public void testFindStatement(){
		Teacher teacher= teacherRepo.findOne(2);
		List<Statement> listStatement= statementRepo.findByteacher(teacher);
		assertEquals("Found wrong number of statements", 1, listStatement.size());
		assertEquals("Found wrong statement", "realizas una función matematica que utilice el algoritmo de fibonacci", listStatement.get(0).getStatementText());
		assertEquals("Found wrong title statement","fibonacci",listStatement.get(0).getTitle());
		
	}
}

