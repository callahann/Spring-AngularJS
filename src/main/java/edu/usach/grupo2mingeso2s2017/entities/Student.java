package edu.usach.grupo2mingeso2s2017.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_student")
	private int idStudent;

	private String email;

	@Column(name="last_name")
	private String lastName;

	private String name;

	//bi-directional many-to-one association to Code
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private List<Code> codes;

	//bi-directional many-to-one association to Record
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private List<Record> records;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="id_section")
	@JsonIgnore
	private Section section;

	public Student() {
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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

	public List<Code> getCodes() {
		return this.codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

	public Code addCode(Code code) {
		getCodes().add(code);
		code.setStudent(this);

		return code;
	}

	public Code removeCode(Code code) {
		getCodes().remove(code);
		code.setStudent(null);

		return code;
	}

	public List<Record> getRecords() {
		return this.records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public Record addRecord(Record record) {
		getRecords().add(record);
		record.setStudent(this);

		return record;
	}

	public Record removeRecord(Record record) {
		getRecords().remove(record);
		record.setStudent(null);

		return record;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}