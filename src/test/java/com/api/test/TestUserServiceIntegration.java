package com.api.test;

import org.testng.annotations.Test;
import com.api.base.UsersService;
import com.api.models.request.AddNewUserRequestData;

public class TestUserServiceIntegration extends BaseTest {
	
	@Test
	public void testIntegrateUserServices() {
		UsersService usersService =new UsersService();
		
		AddNewUserRequestData addNewUserRequestData=new AddNewUserRequestData("raam", "raam@gmail.com", "@ayodya123");
		usersService.addNewUser(addNewUserRequestData);
		logger.info("addNewUserRequestData"+addNewUserRequestData);
		
		
		
	}
}
