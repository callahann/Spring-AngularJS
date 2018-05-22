package edu.usach.grupo2mingeso2s2017.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.usach.grupo2mingeso2s2017.entities.Section;
import edu.usach.grupo2mingeso2s2017.entities.Teacher;

public interface SectionRepository extends PagingAndSortingRepository<Section, Integer>{
	Section findBySectionCode(String name_section);

    Iterable<Section> findByTeacher(Teacher teacher);
}
