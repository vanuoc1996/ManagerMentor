package com.vti.entity.Converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

import com.vti.Enum.RequestStatus;
@Converter
public class RequestStatusConverter implements AttributeConverter<RequestStatus, String> {

	@Override
	public String convertToDatabaseColumn(RequestStatus attribute) {
		if (attribute != null)
			return attribute.getValue();

		return null;
	}

	@Override
	public RequestStatus convertToEntityAttribute(String dbData) {
		if (dbData != null)
			return RequestStatus.of(dbData);

		return null;
	}

}
