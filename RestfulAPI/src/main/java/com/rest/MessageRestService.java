package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

//http://localhost:8085/RestfulAPI/message/oi
@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessagePathParam(@PathParam("param") String msg) {
		
		JSONObject json = new JSONObject();
		json.accumulate("message", msg);
		 
		return Response.status(200).header("Content-Type","application/json").entity(json.toString()).build();

	}
	
	//http://localhost:8085/RestfulAPI/message?q=oi
	@GET
	public Response printMessageQueryParam(@QueryParam("q") String q) {
		
		JSONObject json = new JSONObject();
		json.accumulate("message", q);
		 
		return Response.status(200).header("Content-Type","application/json").entity(json.toString()).build();
	}

}