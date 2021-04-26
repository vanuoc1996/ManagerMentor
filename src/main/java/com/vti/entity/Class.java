package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.TeachingForm;
import com.vti.entity.Converter.ClassStatusConverter;
import com.vti.entity.Converter.TeachingFormConverter;
import com.vti.validation.annotation.ClassNameNotExists;

/**
 * @author Administrator
 *
 */
@Entity
@Table(catalog = "mentormanagement", name = "class")
public class Class implements Serializable {

	@Column(name = "ClassId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;

	@Column(name = "ClassName", unique = false, nullable = false)
	private String className;

	@Column(name = "StartDate", nullable = false)
	private Date startDate;

	@Column(name = "EndDate" )
	private Date endDate;

	@Column(name = "Description", length = 100)
	private String Description;

	@Column(name = "ClassStatus")
	@Convert(converter = ClassStatusConverter.class)
	private ClassStatus classStatus;

	@Column(name = "StudentNumber", nullable = false)
	private int studentNumber;

	@Column(name = "TeachingForm")
	@Convert(converter = TeachingFormConverter.class)
	private TeachingForm teachingForm;

	@OneToMany(mappedBy = "classs")
	private Set<ClassRequest> classRequest;

	public Class() {
		// TODO Auto-generated constructor stub
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public ClassStatus getClassStatus() {
		return classStatus;
	}

	public void setClassStatus(ClassStatus classStatus) {
		this.classStatus = classStatus;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(TeachingForm teachingForm) {
		this.teachingForm = teachingForm;
	}

	public Set<ClassRequest> getClassRequest() {
		return classRequest;
	}

	public void setClassRequest(Set<ClassRequest> classRequest) {
		this.classRequest = classRequest;
	}

	@Override
	public String toString() {
//		for (ClassRequest classRequest2 : classRequest) {
//			System.out.println(classRequest2.getId());
//		}
		return "Class [id=" + id + ", className=" + className + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", Description=" + Description + ", classStatus=" + classStatus + ", studentNumber=" + studentNumber
				+ ", teachingForm=" + teachingForm + "]";
	}

}
