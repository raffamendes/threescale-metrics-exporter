package com.rmendes.threescale.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metric {
	
	public Long id;
	
	public String name;
	
	@JsonProperty("system_name")
	public String systemName;
	
	@JsonProperty("friendly_name")
	public String friendlyName;
	
	public String unit;

}
