/**
 * @author: LQHuy
 * @create_date: Mar 13, 2021
 * @TODO
 * @MapListDto
 */
package com.vti.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vti.dto.response.ClassRequestDTOView;
import com.vti.entity.ClassRequest;
import com.vti.service.ClassRequestService;
import com.vti.service.ClassService;

/**
 * @author Administrator
 *
 */
@Component
public class MapListDto {
	
	@Autowired
	private ClassRequestService CS ;

	/**
	 * 
	 * thí method use to cast list classRequest to classRequestDTOView
	 * 
	 * @param ListEntity
	 * @param classs
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 13, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 13, 2021
	 * @return: List<ClassRequestDTOView>
	 *
	 */
	public List<ClassRequestDTOView> toDtoList(List<ClassRequest> ListEntity, Class classs) {
		Type t = classs.getSuperclass();

		List<ClassRequestDTOView> ListDto = new ArrayList();
		ModelMapper modelMaper = new ModelMapper();
		for (ClassRequest classRequest : ListEntity) {
			ListDto.add(CS.toDto(classRequest));
		}
		return ListDto;
	}

}
