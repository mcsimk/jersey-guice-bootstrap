package com.mcsimk.sample.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("hello")
public class SampleController {

	private String helloWorldString;

	@Inject
	public SampleController(@Named("hello.world.string") final String helloWorldString) {
		this.helloWorldString = helloWorldString;
	}

	@GET
	@Produces("application/json")
	public Response helloWorld(){
		return Response.ok(helloWorldString+"\n").build();
	}
}
