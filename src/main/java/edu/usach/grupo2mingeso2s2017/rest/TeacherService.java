package edu.usach.grupo2mingeso2s2017.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.usach.grupo2mingeso2s2017.entities.Teacher;
import edu.usach.grupo2mingeso2s2017.repository.TeacherRepository;

@CrossOrigin
@RestController  
@RequestMapping("/teachers")
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Teacher> getAllUsers() {
		return teacherRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Teacher findOne(@PathVariable("id") Integer id) {
		return teacherRepository.findOne(id);
	}
	
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	@ResponseBody
	public Teacher findTeacherByEmail(@PathVariable("email") String email) {
		return teacherRepository.findTeacherByEmail(email);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Teacher create(@RequestBody Teacher resource) {
	     return teacherRepository.save(resource);
	}
	
}