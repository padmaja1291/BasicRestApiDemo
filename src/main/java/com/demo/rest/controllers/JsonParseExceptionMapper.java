package com.demo.rest.controllers;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.JsonParseException;
import com.demo.rest.models.ErrorModel;
/**
 * This class handles Json Parse Exception. i.e. Json object not formed properly
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Override
	public Response toResponse(JsonParseException exception) {
		
		ErrorModel errorModelObj = new ErrorModel(request.getMethod(), uriInfo.getRequestUri().toString(), "Not a JSON object");
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(errorModelObj).type(MediaType.APPLICATION_JSON)
				.build();
	}

}
