package service;

import model.User;

public class UserCreator {
    public static final String USER_NAME = "testdata.username";
    public static final String USER_PASSWORD = "testdata.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(USER_NAME), "");
    }
}
