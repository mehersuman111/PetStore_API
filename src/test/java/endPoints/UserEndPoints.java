package endPoints;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payLoad.user.UserData;
import payLoad.user.UserPayload;

import java.util.List;

import static io.restassured.RestAssured.given;

//Created for perform CRUD operations on User module
public class UserEndPoints {

    public static Response createUser(List<UserData> payload) {

        Response response = given()
                .filter(new RequestLoggingFilter(System.out))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.createUser);
        return response;
    }
    public static Response getUser(String username) {

        Response response = given()
                .filter(new RequestLoggingFilter(System.out))
                .pathParam("username", username)
                .when()
                .get(Routes.getUser);
        return response;
    }
    public static Response updateUser(String username, UserPayload payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Routes.updateUser);
        return response;
    }
    public static Response deleteUser(String username) {

        Response response = given()
                .pathParam("username", username)
                .when()
                .delete(Routes.deleteUser);
        return response;
    }
}