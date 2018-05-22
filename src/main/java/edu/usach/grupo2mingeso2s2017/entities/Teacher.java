package edu.usach.grupo2mingeso2s2017.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_teacher")
	private int idTeacher;

	private int coordinator;

	private String email;

	@Column(name="last_name")
	private String lastName;

	private String name;

	//bi-directional many-to-one association to Section
	@OneToMany(mappedBy="teacher")
	@JsonIgnore
	private List<Section> sections;

	//bi-directional many-to-one association to Statement
	@OneToMany(mappedBy="teacher")
	@JsonIgnore
	private List<Statement> statements;

	public Teacher() {
	}

	public int getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public int getCoordinator() {
		return this.coordinator;
	}

	public void setCoordinator(int coordinator) {
		this.coordinator = coordinator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Section addSection(Section section) {
		getSections().add(section);
		section.setTeacher(this);

		return section;
	}

	public Section removeSection(Section section) {
		getSections().remove(section);
		section.setTeacher(null);

		return section;
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public Statement addStatement(Statement statement) {
		getStatements().add(statement);
		statement.setTeacher(this);

		return statement;
	}

	public Statement removeStatement(Statement statement) {
		getStatements().remove(statement);
		statement.setTeacher(null);

		return statement;
	}

}