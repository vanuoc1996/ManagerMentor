package com.vti.entity.Converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.Enum.ClassStatus;

@Converter
public class ClassStatusConverter implements AttributeConverter<ClassStatus, String> {

	@Override
	public String convertToDatabaseColumn(ClassStatus classStatus) {
		if(classStatus == null) {
			return null;
		}
		return classStatus.getValue();
	}

	@Override
	public ClassStatus convertToEntityAttribute(String classStatus) {
		if(classStatus==null) {
			return null;
		}
		return ClassStatus.of(classStatus);
	}
	

}
