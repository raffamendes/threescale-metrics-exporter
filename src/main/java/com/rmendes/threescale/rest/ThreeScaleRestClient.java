package com.rmendes.threescale.rest;

import java.time.LocalDateTime;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.rmendes.threescale.model.enums.Granularity;
import com.rmendes.threescale.model.enums.Period;

import io.vertx.core.json.JsonObject;


	
@RegisterRestClient(configKey = "threescale-api")
@Singleton
public interface ThreeScaleRestClient {
	
	@GET
	@Path("/admin/api/services.json")
	JsonObject getAllServices(@QueryParam(value = "access_token") String accessToken);
	
	@GET
	@Path("admin/api/services/{serviceId}/metrics.json")
	JsonObject getMetricsByService(@PathParam("serviceId") Integer serviceId, @QueryParam(value = "access_token") String accessToken);
	
	@GET
	@Path("/stats/services/{serviceId}/usage.json")
	JsonObject getMetricsByInput(
			@PathParam("serviceId") Integer serviceId, 
			@QueryParam(value = "access_token") String accessToken, 
			@QueryParam("metric_name") String metricName, 
			@QueryParam("since") LocalDateTime since, 
			@QueryParam("until") LocalDateTime until, 
			@QueryParam("period") Period period,
			@QueryParam("granularity") Granularity granularity, 
			@QueryParam("skip_change") boolean skipChange);

}
