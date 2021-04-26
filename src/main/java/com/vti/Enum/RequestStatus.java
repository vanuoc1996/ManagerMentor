package com.vti.Enum;

public enum RequestStatus {
	Waiting("-1"), Accepted("0"), Refused("1");
	
	private String value;
	
	private RequestStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static RequestStatus of(String value) {
		for (RequestStatus RS : RequestStatus.values()) {
			if(RS.getValue().equals(value)) {
				return RS;
			}
		}
		
		return null;
	}
}
