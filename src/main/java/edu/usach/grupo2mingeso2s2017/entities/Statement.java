package edu.usach.grupo2mingeso2s2017.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the statement database table.
 * 
 */
@Entity
@Table(name="statement")
@NamedQuery(name="Statement.findAll", query="SELECT s FROM Statement s")
public class Statement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_statement")
	private int idStatement;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String input;

	private String solution;

	@Column(name="statement_text")
	private String statementText;

	private String title;

	//bi-directional many-to-one association to Code
	@OneToMany(mappedBy="statement")
	@JsonIgnore
	private List<Code> codes;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	@JoinColumn(name="id_teacher")
	@JsonIgnore
	private Teacher teacher;

	public Statement() {
	}

	public int getIdStatement() {
		return this.idStatement;
	}

	public void setIdStatement(int idStatement) {
		this.idStatement = idStatement;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getSolution() {
		return this.solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getStatementText() {
		return this.statementText;
	}

	public void setStatementText(String statementText) {
		this.statementText = statementText;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Code> getCodes() {
		return this.codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

	public Code addCode(Code code) {
		getCodes().add(code);
		code.setStatement(this);

		return code;
	}

	public Code removeCode(Code code) {
		getCodes().remove(code);
		code.setStatement(null);

		return code;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}