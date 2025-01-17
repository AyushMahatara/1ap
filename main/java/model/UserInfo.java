package model;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private String username;

    private String phonenumber;

    private String password;

    public UserInfo(String username, String phonenumber, String password) {
        this.username = username;
        this.phonenumber = phonenumber;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
