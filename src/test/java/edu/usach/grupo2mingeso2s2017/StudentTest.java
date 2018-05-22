package edu.usach.grupo2mingeso2s2017;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.usach.grupo2mingeso2s2017.entities.Student;

import edu.usach.grupo2mingeso2s2017.repository.StudentRepository;


import static org.junit.Assert.assertEquals;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
	@Autowired
	StudentRepository studentRepo;
	
	@Test
	public void testLoadStudents ()
	{
		List<Student> students = (ArrayList<Student>)studentRepo.findAll();
		long count= studentRepo.count();
		assertEquals("Didn't get all students", count, students.size());
	}
	@Test
	public void testFindStudent(){
		List<Student> listDiego= studentRepo.findByemail("humberto.paredes@usach.cl");
		assertEquals("Found wrong number of students", 1, listDiego.size());
		assertEquals("Found wrong name", "Humberto", listDiego.get(0).getName());
		assertEquals("Found wrong Lastname", "Paredes", listDiego.get(0).getLastName());
	}
}

