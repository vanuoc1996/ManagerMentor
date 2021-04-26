/**
 * @author: LQHuy
 * @create_date: Mar 7, 2021
 * @TODO
 * @IdExistsValidation
 */
package com.vti.validation.converter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vti.entity.Class;
import com.vti.repository.IClassRepository;
import com.vti.service.ClassService;
import com.vti.validation.annotation.IdExists;

/**
 * @author Administrator
 *
 */
@Component
public class IdExistsValidation implements ConstraintValidator<IdExists, Short> {

	@Autowired
	private IClassRepository classRepository;

	@Autowired
	private ClassService classService;

	static boolean ckeckss;

	/**
	 * 
	 * 
	 * 
	 * @param constraintAnnotation
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 18, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 18, 2021
	 *
	 */
	@Override
	public void initialize(IdExists constraintAnnotation) {
		// TODO Auto-generated method stub
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	/**
	 * 
	 * 
	 * 
	 * @param value
	 * @param context
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 7, 2021
	 *
	 */
	@Override
	public boolean isValid(Short id, ConstraintValidatorContext context) {
		
		if(id == null) {
			return true;
		}
		
		if (classRepository == null) {
			return true;
		}

		return classRepository.existsById(id);

	}

}
