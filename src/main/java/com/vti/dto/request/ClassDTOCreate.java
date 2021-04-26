/**
 * @author: LQHuy
 * @create_date: Mar 13, 2021
 * @TODO
 * @ClassDTOCreate
 */
package com.vti.dto.request;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.TeachingForm;
import com.vti.validation.annotation.ClassNameNotExists;

/**
 * @author Administrator
 *
 */
public class ClassDTOCreate {
	@NotBlank(message = "{ClassDTO.ClassName.NotBlank}")
	@Length(max = 30, message = "{ClassDTO.ClassName.MaxLength}")
	@Length(min = 6, message = "Length of Class name must not lower than 6")
	@ClassNameNotExists
	private String className;

	@NotNull(message = "{ClassDTO.StartDate.NotNull}")
	private String startDate;

	@NotNull(message = "{ClassDTO.EndDate.NotNull}")
	private String endDate;
	
	@Length(max = 100, message = "{ClassDTO.Description.MaxLength}")
	@NotBlank(message = "{ClassDTO.Description.NotBlank}")
	private String Description;

	@Null(message = "{ClassDTO.ClassStatus.null}")
	private ClassStatus classStatus;

	@NotNull(message = "{ClassDTO.StudentNumber.NotNull}")
	@Max(value = 50, message = "Number of student must not over 50")
	@Min(value = 0, message = "Number of student must not lower than 0")
	private Integer studentNumber;

	@NotNull(message = "{ClassDTO.TeachingForm.NotNull}")
	private TeachingForm teachingForm;

	public String getClassName() {
		return className;
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

	public ClassStatus getClassStatus() {
		return classStatus;
	}

}
