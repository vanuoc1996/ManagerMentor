/**
 * @author: LQHuy
 * @create_date: Mar 6, 2021
 * @TODO
 * @ClassDTOCreateAndView
 */
package com.vti.dto.response;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.TeachingForm;
import com.vti.validation.annotation.ClassNameNotExists;

/**
 * @author Administrator
 *
 */
public class ClassDTOView {

	private Short id;

	@NotBlank(message = "{ClassDTO.ClassName.NotBlank}")
	@Length(max = 30, message = "{ClassDTO.ClassName.MaxLength}")
	@ClassNameNotExists
	private String className;

	@NotNull(message = "{ClassDTO.StartDate.NotNull}")
	private String startDate;

	@NotNull(message = "{ClassDTO.EndDate.NotNull}")
	private String endDate;

	@Length(max = 100, message = "{ClassDTO.Description.MaxLength}")
	@NotBlank(message = "{ClassDTO.Description.NotBlank}")
	private String Description;

	@NotNull(message = "{ClassDTO.ClassStatus.NotNull}")
	private ClassStatus classStatus;

	@NotNull(message = "{ClassDTO.StudentNumber.NotNull}")
	private Integer studentNumber;

	@NotNull(message = "{ClassDTO.TeachingForm.NotNull}")
	private TeachingForm teachingForm;

	private String mentorName;

	public String getClassName() {
		return className;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(TeachingForm teachingForm) {
		this.teachingForm = teachingForm;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	@Override
	public String toString() {
		return "ClassDto [ className=" + className + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", Description=" + Description + ", classStatus=" + classStatus + ", studentNumber=" + studentNumber
				+ ", teachingForm=" + teachingForm + "]";
	}

}
