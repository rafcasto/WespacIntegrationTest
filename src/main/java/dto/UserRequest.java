package dto;

import java.time.LocalTime;

public class UserRequest extends BaseResponse
{
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

    public UserRequest()
    {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username)
    {

        this.username = transformUserName(username);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String getRandomNumber()
    {
        LocalTime dateTime = LocalTime.now();

        return dateTime.toString().replace(":","").replace(".","");
    }

    private String transformUserName(String userName)
    {
        if(username == null || username.isEmpty()){
            return "";
        }
        return username + "_" + getRandomNumber();
    }
}
