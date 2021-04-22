package com.rmendes.threescale.model.enums;

public enum Period {
	

	YEAR("year"), MONTH("month"), DAY("day"), HOUR("hour");
	
	String period;
	
	private Period(String period) {
		this.period = period;
	}

	public String getPeriod() {
		return period;
	}

}
