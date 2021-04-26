package com.vti.service;

import java.util.List;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.RequestStatus;
import com.vti.dto.request.ClassDTOCreate;
import com.vti.dto.request.ClassDTOUpdate;
import com.vti.dto.response.ClassDTOView;
import com.vti.entity.Class;

public interface IClassService {
	
	
	ClassDTOView findClassById(Short id) throws Exception;
	
	void updateClass(ClassDTOUpdate classUpdate);
	
	void deleteClass(Short id);
	
	boolean existsByClassName(String className);	
	
	public Class findClassByClassName(String className);

	/**
	 * 
	 * 
	 * 
	 * @param classCreate
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: void
	 * @throws Exception 
	 *
	 */
	void createClass(ClassDTOCreate classCreate) throws Exception;


	/**
	 * 
	 * 
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @param classStatus
	 * @param className
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 19, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 19, 2021
	 * @return: List<ClassDTOView>
	 *
	 */
	List<ClassDTOView> getAllClass(Integer pageSize, Integer pageNumber, ClassStatus classStatus, String className);
}
