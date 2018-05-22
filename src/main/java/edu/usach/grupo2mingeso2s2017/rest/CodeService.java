package edu.usach.grupo2mingeso2s2017.rest;

import edu.usach.grupo2mingeso2s2017.entities.Statement;
import edu.usach.grupo2mingeso2s2017.entities.Student;
import edu.usach.grupo2mingeso2s2017.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.usach.grupo2mingeso2s2017.entities.Code;
import edu.usach.grupo2mingeso2s2017.repository.CodeRepository;
import edu.usach.grupo2mingeso2s2017.repository.StudentRepository;

@CrossOrigin
@RestController  
@RequestMapping("/codes")
public class CodeService {
	@Autowired
	private CodeRepository codeRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StatementRepository statementRepository;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Code> getAllUsers() {
		return codeRepository.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Code findOne(@PathVariable("id") Integer id) {
		return codeRepository.findOne(id);
	}


	@RequestMapping(value = "/{idStudent}/{idStatement}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Code create(@PathVariable("idStudent") Integer idStudent,@PathVariable("idStatement") Integer idStatement, @RequestBody Code resource) {
		Student student = studentRepository.findOne(idStudent);
		Statement statement = statementRepository.findOne(idStatement);
		resource.setStudent(student);
		resource.setStatement(statement);
		return codeRepository.save(resource);
	}
}

