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

import edu.usach.grupo2mingeso2s2017.entities.Section;
import edu.usach.grupo2mingeso2s2017.entities.Teacher;
import edu.usach.grupo2mingeso2s2017.repository.SectionRepository;
import edu.usach.grupo2mingeso2s2017.repository.TeacherRepository;


@CrossOrigin
@RestController  
@RequestMapping("/sections")
public class SectionService {
	@Autowired
	private SectionRepository sectionRepository;
	@Autowired
	private TeacherRepository teacherRepository;


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Section> getAllUsers() {
		return sectionRepository.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Section findOne(@PathVariable("id") Integer id) {
		return sectionRepository.findOne(id);
	}

    @RequestMapping(value = "/getSectionsByTeacher/{idTeacher}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Section> getSectionsByTeacher(@PathVariable("idTeacher") Integer idTeacher) {
        Teacher teacher = teacherRepository.findOne(idTeacher);
        return sectionRepository.findByTeacher(teacher);
    }


	@RequestMapping(value = "/{idTeacher}",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Section create(@PathVariable("idTeacher") Integer idTeacher, @RequestBody Section resource) {
		Teacher teacher = teacherRepository.findOne(idTeacher);
		resource.setTeacher(teacher);
		return sectionRepository.save(resource);
	}
}
