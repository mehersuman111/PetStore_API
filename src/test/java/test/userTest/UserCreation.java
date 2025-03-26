package test.userTest;

import com.github.javafaker.Faker;
import endPoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payLoad.user.UserData;
import payLoad.user.UserPayload;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserCreation {

    Faker faker;
    //UserPayload userPayload;
    UserData userData;
    ArrayList<UserData> userDataList;
    @BeforeClass
    public void setUp() {
        // Set up the test data
        faker = new Faker();

        //userPayload = new UserPayload();
        userData = new UserData();
        userDataList = new ArrayList<UserData>();

        userData.setId(faker.idNumber().hashCode());
        userData.setUsername(faker.name().username());
        userData.setFirstName(faker.name().firstName());
        userData.setLastName(faker.name().lastName());
        userData.setEmail(faker.internet().safeEmailAddress());
        userData.setPassword(faker.internet().password(5,10));
        userData.setPhone(faker.phoneNumber().cellPhone());
        userData.setUserStatus(faker.number().numberBetween(0, 1));

       // List<UserData> userDataList= new ArrayList<UserData>();
        userDataList.add(userData);
        //userPayload.setUserData(userDataList);

        System.out.println("User Payload: " + userDataList.toString());
    }

    @Test(priority = 0, description = "Create a new user")
    public void testUserCreation() {
        // Create a new user
        Response response = UserEndPoints.createUser(userDataList);
        System.out.println("User Payload: " + userDataList.toString());
        //..response.prettyPrint();
        response.then().log().all().statusCode(200);
    }
    @Test(priority = 1, description = "Create a new user")
    public void testGetUser() {
        // CreaGette a new user
        Response getResponse =  UserEndPoints.getUser("TestUser1");
        //System.out.println("User Payload: " + this.userPayload.toString());
        //..response.prettyPrint();
        getResponse.then().statusCode(404);
        getResponse.then().log().all();
        Assert.assertEquals(getResponse.statusCode(),200);
    }

}
