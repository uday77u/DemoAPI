package com.api.base;

import io.restassured.response.Response;

public class UsersService extends Fakestoreapi_baseService {
	private final static String UsersPath="/users/";
	
	public Response getSingleUser(int id) {
		return getRequest(UsersPath+id);
	}
	
	public Response getAllUsers() {
		return getRequest(UsersPath);
	}
	
	public Response addNewUser(Object payload) {
		return postRequest(payload, UsersPath);
	}
	
	public Response updateUserPut(Object payload,int id) {
		return putRequest(payload, UsersPath+id);
	}
	
	public Response updateUserPatch(String payload,int id) {
		return patchRequest(payload, UsersPath+id);
	}

	public Response deleteUser(int id) {
		return deleteRequest(UsersPath+id);
	}
}
