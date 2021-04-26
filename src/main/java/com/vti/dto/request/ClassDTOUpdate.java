package com.vti.dto.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.TeachingForm;
import com.vti.entity.Class;
import com.vti.entity.Converter.ClassStatusConverter;
import com.vti.entity.Converter.TeachingFormConverter;
import com.vti.validation.annotation.ClassNameNotExists;
import com.vti.validation.annotation.IdExists;

public class ClassDTOUpdate {
	
	@NotNull(message = "{ClassDTO.Id.NotNull}")
	@IdExists
	private Short id;
	
	@NotBlank(message = "{ClassDTO.ClassName.NotBlank}")
	@Length(max = 30, message = "{ClassDTO.ClassName.MaxLength}")
	@Length(min = 6, message = "Length of Class name must not greater than 6")
//	@ClassNameNotExists
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
	@Max(value = 50, message = "Number of student must not over 50")
	@Min(value = 0, message = "Number of student must not lower than 0")
	private Integer studentNumber;

	@NotNull(message = "{ClassDTO.TeachingForm.NotNull}")
	private TeachingForm teachingForm;

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

	@Override
	public String toString() {
		return "ClassDto [id=" + id + ", className=" + className + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", Description=" + Description + ", classStatus=" + classStatus + ", studentNumber=" + studentNumber
				+ ", teachingForm=" + teachingForm + "]";
	}
	
	
	
}
