package edu.usach.grupo2mingeso2s2017.rest;

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

import edu.usach.grupo2mingeso2s2017.entities.Record;
import edu.usach.grupo2mingeso2s2017.entities.Student;
import edu.usach.grupo2mingeso2s2017.repository.RecordRepository;
import edu.usach.grupo2mingeso2s2017.repository.StudentRepository;

@CrossOrigin
@RestController  
@RequestMapping("/records")
public class RecordService {
	@Autowired
	private RecordRepository recordRepository;

	@Autowired
	private StudentRepository studentRepository;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Record> getAllUsers() {
		return recordRepository.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Record findOne(@PathVariable("id") Integer id) {
		return recordRepository.findOne(id);
	}


	@RequestMapping(value = "/{idStudent}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Record create(@PathVariable("idStudent") Integer idStudent, @RequestBody Record resource) {
		Student student = studentRepository.findOne(idStudent);
		resource.setStudent(student);
		return recordRepository.save(resource);
	}

}