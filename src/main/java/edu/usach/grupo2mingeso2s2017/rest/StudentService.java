package edu.usach.grupo2mingeso2s2017.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.usach.grupo2mingeso2s2017.entities.Section;
import edu.usach.grupo2mingeso2s2017.entities.Student;
import edu.usach.grupo2mingeso2s2017.repository.SectionRepository;
import edu.usach.grupo2mingeso2s2017.repository.StudentRepository;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SectionRepository sectionRepository;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Student> getAllUsers() {
		return studentRepository.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Student findOne(@PathVariable("id") Integer id) {
		return studentRepository.findOne(id);
	}

	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	@ResponseBody
	public Student findStudenByEmail(@PathVariable("email") String email) {
		return studentRepository.findStudenByEmail(email);
	}

	@RequestMapping(value = "/getStudentsBySection/{idSection}", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Student> getStudentsById(@PathVariable("idSection") Integer idSection) {
		Section section = sectionRepository.findOne(idSection);
		return studentRepository.findBySection(section);
	}

	@RequestMapping(value = "/{idSection}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Student create(@PathVariable("idSection") Integer idSection, @RequestBody Student resource) {
		Section section = sectionRepository.findOne(idSection);
		resource.setSection(section);
		return studentRepository.save(resource);
	}



}