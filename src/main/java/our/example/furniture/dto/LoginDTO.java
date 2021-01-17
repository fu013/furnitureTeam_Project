package our.example.furniture.dto;

public class LoginDTO {

    private String userLoginID;
    private String userLoginPassword;

    public String getUserLoginID() {
        return userLoginID;
    }
    public void setUserLoginID(String userLoginID) {
        this.userLoginID = userLoginID;
    }
    public String getUserLoginPassword() {
        return userLoginPassword;
    }
    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }
}
