package edu.usach.grupo2mingeso2s2017.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.usach.grupo2mingeso2s2017.entities.Statement;
import edu.usach.grupo2mingeso2s2017.entities.Teacher;
import edu.usach.grupo2mingeso2s2017.repository.StatementRepository;
import edu.usach.grupo2mingeso2s2017.repository.TeacherRepository;

@CrossOrigin
@RestController  
@RequestMapping("/statements")
public class StatementService {
	@Autowired
	private StatementRepository statementRepository;
	@Autowired
	private TeacherRepository teacherRepository;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Statement> getAllUsers() {
		return statementRepository.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Statement findOne(@PathVariable("id") Integer id) {
		return statementRepository.findOne(id);
	}


	@RequestMapping(value = "/getStatementsByStudent/{idStudent}", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Statement> getStatementsByStudent(@PathVariable("idStudent") Integer idStudent) {
		return statementRepository.findByStudent(idStudent);
	}

	@RequestMapping(value = "/{idTeacher}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Statement create(@PathVariable("idTeacher") Integer idTeacher, @RequestBody Statement resource) {
		Teacher teacher = teacherRepository.findOne(idTeacher);
		resource.setTeacher(teacher);
		return statementRepository.save(resource);
	}

}
