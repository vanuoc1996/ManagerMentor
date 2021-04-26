package com.vti.entity.Converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

import com.vti.Enum.TeachingForm;

@Converter
public class TeachingFormConverter implements AttributeConverter<TeachingForm, String> {

	@Override
	public String convertToDatabaseColumn(TeachingForm attribute) {
		if (attribute != null) {
			return attribute.getValue();
		}

		return null;
	}

	@Override
	public TeachingForm convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			return TeachingForm.of(dbData);
		}
		return null;
	}

}
