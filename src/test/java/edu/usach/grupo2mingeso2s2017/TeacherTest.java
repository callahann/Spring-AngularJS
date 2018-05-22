package edu.usach.grupo2mingeso2s2017;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import edu.usach.grupo2mingeso2s2017.entities.Teacher;

import edu.usach.grupo2mingeso2s2017.repository.TeacherRepository;

import static org.junit.Assert.assertEquals;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {
	@Autowired
	TeacherRepository teacherRepo;
	
	@Test
	public void testLoadTeacher ()
	{
		List<Teacher> teachers = (ArrayList<Teacher>)teacherRepo.findAll();
		long count= teacherRepo.count();
		assertEquals("Didn't get all Teachers", count, teachers.size());
	}
	@Test
	public void testFindTeacher(){
		
		List<Teacher> listjuan= teacherRepo.findByemail("juan.dias@usach.cl");
		assertEquals("Found wrong number of teachers", 1, listjuan.size());
		assertEquals("Found wrong name", "Juan", listjuan.get(0).getName());
		assertEquals("Found wrong Lastname", "Dias", listjuan.get(0).getLastName());

	}
}

