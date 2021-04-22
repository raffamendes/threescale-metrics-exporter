package com.rmendes.threescale.model.enums;

public enum Granularity {

	MONTH("month"), DAY("day"), HOUR("hour");
	
	String granularity;
	
	private Granularity(String granularity) {
		this.granularity = granularity;
	}

	public String getGranularity() {
		return granularity;
	}
	
	
}
