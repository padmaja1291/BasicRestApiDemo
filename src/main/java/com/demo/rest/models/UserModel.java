package com.demo.rest.models;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnySetter;
/**
 * Model Class for UserModel
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
public class UserModel {

	private Map<String, String> userObjMap;

	public UserModel() {
		userObjMap = new HashMap<String, String>();
	}

	@JsonAnySetter
	public void addUserAttributes(String key, String value) {
		userObjMap.put(key, value);
	}

	public Map<String, String> getUser() {
		return userObjMap;
	}

}
