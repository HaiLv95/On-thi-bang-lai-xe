package testController;


import org.testng.annotations.Test;


public class changePasswordControllerTest {

	@Test
	public void changePasswordController_TC001() {
		changePasswordController changePass = new changePasswordController();
		String email = "haiph@gmail.com";
		String pass  = "1";
		changePass.changePassword(email, pass);
	}
}
