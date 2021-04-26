/**
 * @author: LQHuy
 * @create_date: Mar 6, 2021
 * @TODO
 * @ClassNameNotExists
 */
package com.vti.validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.vti.validation.annotation.ClassNameNotExists.List;
import com.vti.validation.converter.ClassNameNotExistsValidation;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ClassNameNotExistsValidation.class})
//@Repeatable(List.class)
public @interface ClassNameNotExists {
	
	String message() default "The class name must be not exists already";
	int gggg() default 12;
	
	Class<?> [] groups() default {};
	
	Class<? extends Payload> [] payload() default{};
	
	@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
	@interface List{
		ClassNameNotExists[] value();
	}
}
