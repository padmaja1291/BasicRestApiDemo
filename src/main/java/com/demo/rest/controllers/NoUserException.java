package com.demo.rest.controllers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.demo.rest.models.ErrorModel;
/**
 * This class handles  Exception threw when there exists no user.
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
public class NoUserException extends WebApplicationException {


	private static final long serialVersionUID = 1L;

	public NoUserException(ErrorModel errorModel) {
		super(Response.status(Status.NOT_FOUND).entity(errorModel).type(MediaType.APPLICATION_JSON).build());
	
	}
	
}
