package com.vti.Enum;

public enum ClassStatus {
	
	Waiting("-1"),Accepted("0"),Begin("1");
	
	private String value;
	
	private ClassStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
	public static ClassStatus of(String value) {
		for (ClassStatus classStatus : ClassStatus.values()) {
			if(value.equals(classStatus.getValue())){
				return classStatus;
			}
		}
		return null;
	}

}
