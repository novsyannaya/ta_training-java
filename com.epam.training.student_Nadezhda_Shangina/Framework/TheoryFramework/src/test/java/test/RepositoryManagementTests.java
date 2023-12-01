package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserCreator;
import util.StringUtils;

import java.util.Random;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;


public class RepositoryManagementTests extends CommonConditions{
    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";
//    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static Random random = new Random();

    @Test(description = "JIRA-7566")
    public void oneCanCreateProject()
    {
        User user= UserCreator.withCredentialsFromProperty();
        String expectedRepositoryName = StringUtils
                .generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(user)
                .invokeNewRepositoryCreation()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION)
                .getCurrentRepositoryName();


        Assert.assertEquals(createdRepositoryName, expectedRepositoryName);
//        assertThat(createdRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    @Test(description = "JIRA-7567")
    public void newProjectsAreEmpty()
    {
        User user= UserCreator.withCredentialsFromProperty();
        String testRepositoryName = StringUtils
                .generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        boolean isCurrentRepositoryEmpty = new LoginPage(driver)
                .openPage()
                .login(user)
                .invokeNewRepositoryCreation()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();

        Assert.assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }

//    private String getRandomString(int stringLength)
//    {
//        StringBuilder stringBuilder = new StringBuilder(stringLength);
//        for (int i = 0; i < stringLength; i++)
//        {
//            stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
//        }
//        return stringBuilder.toString();
//    }
//
//    private String generateRandomRepositoryNameWithPostfixLength(int postfixLength){
//        return "testRepo_".concat(getRandomString(postfixLength));
//    }
}
