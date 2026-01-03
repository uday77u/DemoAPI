package com.api.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.UsersService;
import com.api.models.request.AddNewUserRequestData;
import com.api.models.request.UpdateUserPutRequestData;
import com.api.models.response.AddNewUserResponseData;
import com.api.models.response.UpdateUserPutResponseData;
import com.api.utilities.AssertionsUtil;
import com.api.utilities.TestListener;

import io.restassured.response.Response;

@Listeners(TestListener.class)
public class TestUserService extends BaseTest{
	
	//@Test
	public void testAllUsers(){
		UsersService usersService=new UsersService();
		 Response response = usersService.getAllUsers();
	//	logger.info("allUsers response:\n "+response.asPrettyString()+"\n");
		//logger.info("allUsers response log: \n"+response.then().log().all()+"\n");
		response.then().assertThat().statusCode(200);
		AssertionsUtil.assertStatusCode(response, 200, logger);
		AssertionsUtil.assertStatusLine200(response, logger);
		AssertionsUtil.assertContentType(response, "application/json", logger);
		AssertionsUtil.assertResponseTime(response, logger);
		AssertionsUtil.assertServerType(response, logger);
		
	}

	//@Test
	public void testSingleUser() {
		UsersService usersService=new UsersService();
		 Response response=usersService.getSingleUser(2);
		//logger.info("singleUser response:\n "+response.asPrettyString()+"\n");
		//logger.info("singleUser response log: "+response.then().log().all()+"\n");
		response.then().assertThat().statusCode(200);
		AssertionsUtil.assertStatusCode(response, 200, logger);
		AssertionsUtil.assertStatusLine200(response, logger);
		AssertionsUtil.assertContentType(response, "application/json", logger);
		AssertionsUtil.assertResponseTime(response, logger);
		AssertionsUtil.assertServerType(response, logger);
	}
	
	//@Test
	public void testAddNewUser() {
		UsersService usersService=new UsersService();
		AddNewUserRequestData addNewUserRequestData=new AddNewUserRequestData("abcd", "Asdf@dfg.com", "@werf%");
		logger.info("AddNewUserRequestData is created: "+addNewUserRequestData);
		
		 Response response=usersService.addNewUser(addNewUserRequestData);
		 AddNewUserResponseData addNewUserResponseData=response.as(AddNewUserResponseData.class);
		 logger.info("AddNewUserResponseData: "+addNewUserResponseData);
		 
		//logger.info("singleUser response:\n "+response.asPrettyString()+"\n");
		//logger.info("singleUser response log: "+response.then().log().all()+"\n");
		response.then().assertThat().statusCode(201);
		AssertionsUtil.assertStatusCode(response, 201, logger);
		AssertionsUtil.assertStatusLine201(response, logger);
		AssertionsUtil.assertContentType(response, "application/json", logger);
		AssertionsUtil.assertResponseTime(response, logger);
		AssertionsUtil.assertServerType(response, logger);
		assertTrue(addNewUserResponseData.getId() > 0, "User ID should be generated");
		logger.info("User ID is generated: "+addNewUserResponseData.getId());
		
	}
	
	@Test
	public void testupdateUserPut() {
		UsersService usersService=new UsersService();
		AddNewUserRequestData addNewUserRequestData=new AddNewUserRequestData("abcd", "Asdf@dfg.com", "@werf%");
		logger.info("AddNewUserRequestData is created: "+addNewUserRequestData);
		
		 Response response=usersService.addNewUser(addNewUserRequestData);
		 AddNewUserResponseData addNewUserResponseData=response.as(AddNewUserResponseData.class);
		 logger.info("AddNewUserResponseData: "+addNewUserResponseData);
		 
		 int id = addNewUserResponseData.getId();
		 logger.info("SingleUser: "+usersService.getSingleUser(id));
		 
		 UpdateUserPutRequestData updateUserPutRequestData=new UpdateUserPutRequestData("newName", "New@gmail.com", "@#$sde123");
		 response=usersService.updateUserPut(updateUserPutRequestData, id);
		 UpdateUserPutResponseData updateUserPutResponseData=response.as(UpdateUserPutResponseData.class);
		 logger.info("updateUserPutResponseData: "+updateUserPutResponseData);
		 
 
		
	}
	
}
