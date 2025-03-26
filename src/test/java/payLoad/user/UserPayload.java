package payLoad.user;

import java.util.List;
public class UserPayload {
    public List<UserData> getUserData() {
        return userData;
    }
    public void setUserData(List<UserData> userData) {
        this.userData = userData;
    }
    private List<UserData> userData;
}