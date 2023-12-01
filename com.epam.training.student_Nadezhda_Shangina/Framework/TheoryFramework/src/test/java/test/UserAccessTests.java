package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserCreator;

public class UserAccessTests extends CommonConditions{
    @Test
    public void oneCanLoginGithub()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(loggedInUserName, testUser.getUsername());
//        assertThat(loggedInUserName, is(equalTo(USER_NAME)));
    }
}
