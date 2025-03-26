package endPoints;
public class Routes {
        public static String baseURL = "https://petstore.swagger.io/v2"; // Correct base URL
        public static String userModule = "/user";
        public static String createUser = baseURL + userModule + "/createWithList"; // Correct endpoint for creating a user
        public static String getUser = baseURL + userModule + "/{username}";
        public static String updateUser = baseURL + userModule + "/{username}";
        public static String deleteUser = baseURL + userModule + "/{username}";
}