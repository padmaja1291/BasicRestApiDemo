package com.demo.rest.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * UsersUidModel contains all the users and methods for adding, updating, deleting and getting the user
 * @author Padmaja Krishnakumar
 * @version 1.0
 * @since 12 April 2016
 */
public enum UsersUidModel {
	instance;

	private Map<String, UserUidModel> usersObjMap = new HashMap<String, UserUidModel>();

	public void addUser(String userUid, UserUidModel userUidModel) {
		usersObjMap.put(userUid, userUidModel);
		
	}

	public Map<String, UserUidModel> getAllUsers() {
		return usersObjMap;
	}

	public void updateUser(String userUid, UserUidModel userUidModel) {
		usersObjMap.put(userUid, userUidModel);
	}

	public Set<String> getAllUserUid() {
		return usersObjMap.keySet();

	}

	public void deleteObject(String userUid) {
		if (usersObjMap.containsKey(userUid))
			usersObjMap.remove(userUid);
	}

}
