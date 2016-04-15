package com.demo.rest.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.demo.rest.models.ErrorModel;
import com.demo.rest.models.UserUidModel;
import com.demo.rest.models.UsersUidModel;
import com.demo.rest.utils.RandomString;
import com.demo.rest.models.UserModel;
import com.demo.rest.models.UrlModel;

import javax.ws.rs.core.UriInfo;

/**
 * This class handles all the rest api requests (create, Read, Update, Delete Operations)
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
@Path("/objects")
public class ObjectController {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(UserModel userModel) {
		Status status;
		RandomString randomString = new RandomString();
		String userUid = randomString.generateRandomUid();
		UserUidModel userUidModel = new UserUidModel(userUid, userModel.getUser());
		UsersUidModel.instance.addUser(userUid, userUidModel);
		status = Status.OK;
		return Response.status(status).entity(userUidModel).type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{uid}")
	public Response updateUser(UserModel userModel, @PathParam("uid") String userUid) {
		if (UsersUidModel.instance.getAllUsers().containsKey(userUid)) {
			UserUidModel userUidModel = new UserUidModel(userUid, userModel.getUser());
			UsersUidModel.instance.updateUser(userUid, userUidModel);
			return Response.status(Status.OK).entity(userUidModel).type(MediaType.APPLICATION_JSON).build();
		} else {
			throw new NoUserException(new ErrorModel(request.getMethod(), uriInfo.getRequestUri().toString(), "Not a valid uid"));
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{uid}")
	public Response readUser(@PathParam("uid") String userUid) {
		
		if (UsersUidModel.instance.getAllUsers().containsKey(userUid)) {
			UserUidModel userUidModel = UsersUidModel.instance.getAllUsers().get(userUid);
			return Response.status(Status.OK).entity(userUidModel).type(MediaType.APPLICATION_JSON).build();
		} else {
			throw new NoUserException(new ErrorModel(request.getMethod(), uriInfo.getRequestUri().toString(), "Not a valid uid"));
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUrls() {
		UrlModel urlmodel;
		List<UrlModel> urlModelList = null;
		Status status;
		String baseUrl = uriInfo.getRequestUri().toString();
		Set<String> userUidKeySet = UsersUidModel.instance.getAllUserUid();
		Iterator<String> iterator = userUidKeySet.iterator();
		if (userUidKeySet.size() > 0) {
			urlModelList = new ArrayList<UrlModel>();
		}

		while (iterator.hasNext()) {
			urlmodel = new UrlModel();
			urlmodel.setUrl(baseUrl + "/" + iterator.next());
			urlModelList.add(urlmodel);
		}
		status = Status.OK;
		return Response.status(status).entity(urlModelList).type(MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{uid}")
	public Response deleteUser(@PathParam("uid") String userUid) {

		UsersUidModel.instance.deleteObject(userUid);

		return Response.noContent().build();
	}

}
