/**
 * @author: LQHuy
 * @create_date: Mar 13, 2021
 * @TODO
 * @ClassRequestDTOView
 */
package com.vti.dto.response;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.RequestStatus;
import com.vti.Enum.TeachingForm;
import com.vti.entity.Class;
import com.vti.entity.Mentor;
import com.vti.entity.Converter.RequestStatusConverter;

/**
 * @author Administrator
 *
 */
public class ClassRequestDTOView {

	private Short id;

	private String className;

	private String description;

	private RequestStatus requestStatus;

	private Integer numberStudent;

	private TeachingForm teachingForm;

	private String mentor;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Integer getNumberStudent() {
		return numberStudent;
	}

	public void setNumberStudent(Integer numberStudent) {
		this.numberStudent = numberStudent;
	}

	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(TeachingForm teachingForm) {
		this.teachingForm = teachingForm;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public void setClassName(String className) {
		this.className = className;
	}



}
