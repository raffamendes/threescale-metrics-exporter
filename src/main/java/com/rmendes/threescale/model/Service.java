package com.rmendes.threescale.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {

	
	public Integer id;

	public String name;

	public String state;

	@JsonProperty("system_name")
	public String systemName;

	public String description;
	
	public List<Metric> metrics = new ArrayList<Metric>();


}
