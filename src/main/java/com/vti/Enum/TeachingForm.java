package com.vti.Enum;

public enum TeachingForm {
	ONLINE("Online"), OFFLINE("Offline");
	
	private String value;
	
	private TeachingForm(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static TeachingForm of(String value) {
		
		for (TeachingForm teachingForm : TeachingForm.values()) {
			if(teachingForm.getValue().equals(value)) {
				return teachingForm;
			}
		}
		
		return null;
	}
	
	

}
