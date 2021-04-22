package com.rmendes.threescale.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmendes.threescale.model.Metric;
import com.rmendes.threescale.model.Service;
import com.rmendes.threescale.rest.ThreeScaleRestClient;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;


@ApplicationScoped
public class ApplicationsService {

	@ConfigProperty(name = "threescale.access.token")
	String accessToken;

	@Inject
	@RestClient
	ThreeScaleRestClient threeScaleClient;

	private static final Logger logger = LoggerFactory.getLogger(ApplicationsService.class);

	public List<Service> findServices() throws JsonMappingException, JsonProcessingException{
		return threeScaleClient.getAllServices(accessToken).getJsonArray("services").
				stream().
				map(s ->{
					try {
						return new ObjectMapper().readValue(((JsonObject)s).getJsonObject("service").toString(),Service.class);
					}catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toList());
	}

	public List<Metric> findServiceMetrics(Integer serviceId) {
		return threeScaleClient.getMetricsByService(serviceId, accessToken).
				getJsonArray("metrics").
				stream().
				map(x -> {
					try {
						return new ObjectMapper().readValue(((JsonObject)x).getJsonObject("metric").toString(),Metric.class);
					}catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toList());
	}

}
