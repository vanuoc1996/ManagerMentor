/**
 * @author: LQHuy
 * @create_date: Mar 19, 2021
 * @TODO
 * @isIntegerValidation
 */
package com.vti.validation.converter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.validation.annotation.isInteger;

/**
 * @author Administrator
 *
 */
public class isIntegerValidation implements ConstraintValidator<isInteger, String> {
	
	/**
	 * 
	 * 
	 * 
	 * @param constraintAnnotation
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 19, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 19, 2021
	 *
	 */
	@Override
	public void initialize(isInteger constraintAnnotation) {
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
	 * @create_date: Mar 19, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 19, 2021
	 *
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null||value.equals("")) {
			return true;
		}
		
		
		try {
			Integer i = Integer.parseInt(value);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	

}
