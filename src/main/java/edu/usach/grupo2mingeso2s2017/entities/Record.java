package edu.usach.grupo2mingeso2s2017.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the record database table.
 * 
 */
@Entity
@Table(name="record")
@NamedQuery(name="Record.findAll", query="SELECT r FROM Record r")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_record")
	private int idRecord;

	@Column(name="statement_solved")
	private int statementSolved;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="id_student")
	@JsonIgnore
	private Student student;

	public Record() {
	}

	public int getIdRecord() {
		return this.idRecord;
	}

	public void setIdRecord(int idRecord) {
		this.idRecord = idRecord;
	}

	public int getStatementSolved() {
		return this.statementSolved;
	}

	public void setStatementSolved(int statementSolved) {
		this.statementSolved = statementSolved;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}