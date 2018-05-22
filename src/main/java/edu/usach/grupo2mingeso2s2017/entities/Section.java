package edu.usach.grupo2mingeso2s2017.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the section database table.
 * 
 */
@Entity
@Table(name="section")
@NamedQuery(name="Section.findAll", query="SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_section")
	private int idSection;

	@Column(name="section_code")
	private String sectionCode;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	@JoinColumn(name="id_teacher")
	@JsonIgnore
	private Teacher teacher;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="section")
	@JsonIgnore
	private List<Student> students;

	public Section() {
	}

	public int getIdSection() {
		return this.idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}

	public String getSectionCode() {
		return this.sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setSection(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setSection(null);

		return student;
	}

}