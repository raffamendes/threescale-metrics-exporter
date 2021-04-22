package com.rmendes.threescale;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rmendes.threescale.data.ApplicationsService;
import com.rmendes.threescale.model.Service;


@Path("/threescale/analytics")
public class AnalyticsResource {


	@Inject
	ApplicationsService service;

	@GET
	@Path("/list/services")
	public Response apps() {
		try {
			List<Service> services = service.findServices();
			services.forEach(s -> s.metrics.addAll(service.findServiceMetrics(s.id)));
			return Response.ok().entity(services).build();
		} catch (JsonProcessingException e) {
			return Response.serverError().entity(e).build();
		}

	}
	
	@POST
	@Path("/service/metrics")
	public Response serviceMetrics() {
		return null;
	}
	
	@POST
	@Path("/all/metrics")
	public Response allMetrics() {
		return null;
	}


}





