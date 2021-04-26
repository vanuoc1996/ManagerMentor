package com.vti.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtils {
	public static <T> boolean validate(T dto) {
		ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(dto);
		
		if(null == constraintViolations || constraintViolations.size() == 0) {
			return true;
		}
		
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation);
		}
		throw new ConstraintViolationException(constraintViolations);
		
		
	}
}
