package in.vl.setuone.model;

public class UserModel
{
    private String emailID;
    private String username;
    private String password;
    private String pushID;

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }

    public UserModel(String emailID , String username , String password , String pushID)
    {
        this.emailID = emailID;
        this.username = username;
        this.password = password;
        this.pushID = pushID;
    }
}
