package com.demo.rest.models;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
/**
 * Model Class UserUidModel contains the structure of response to be displayed for requests
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
public class UserUidModel {
	private String id;
	private Map<String, String> object;

	public UserUidModel() {
		super();
	}

	public UserUidModel(String id, Map<String, String> object) {
		super();
		this.id = id;
		this.object = object;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonAnyGetter
	public Map<String, String> getObject() {
		return object;
	}

	public void setObject(Map<String, String> object) {
		this.object = object;
	}

}