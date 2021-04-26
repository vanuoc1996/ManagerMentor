/**
 * @author: LQHuy
 * @create_date: Mar 13, 2021
 * @TODO
 * @IClassRequestService
 */
package com.vti.service;
import java.util.List;

import com.vti.dto.response.ClassRequestDTOView;
import com.vti.entity.ClassRequest;


public interface IClassRequestService {
	

	

	/**
	 * 
	 * this method use to get class request by id
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: ClassRequest
	 * @throws Exception 
	 *
	 */
	ClassRequestDTOView getClassRequestById(Short id) throws Exception;


	/**
	 * 
	 * 
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 14, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 14, 2021
	 * @return: List<ClassRequest>
	 *
	 */
	public List<ClassRequest> getAllClassRequest(Integer pageSize, Integer pageNumber);
	
	public void RefuseRequest(Short id) throws Exception;
	
	public void AcceptRequest(Short id) throws Exception;
	
	

}
