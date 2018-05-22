package edu.usach.grupo2mingeso2s2017.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the code database table.
 * 
 */
@Entity
@Table(name="code")
@NamedQuery(name="Code.findAll", query="SELECT c FROM Code c")
public class Code implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_code")
	private int idCode;

	private int correct;

	@Column(name="writen_code")
	private String writenCode;

	//bi-directional many-to-one association to Statement
	@ManyToOne
	@JoinColumn(name="id_statement")
	@JsonIgnore
	private Statement statement;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="id_student")
	@JsonIgnore
	private Student student;

	public Code() {
	}

	public int getIdCode() {
		return this.idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public int getCorrect() {
		return this.correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public String getWritenCode() {
		return this.writenCode;
	}

	public void setWritenCode(String writenCode) {
		this.writenCode = writenCode;
	}

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}