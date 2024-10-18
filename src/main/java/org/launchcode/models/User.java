package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long.")
    private String username;
    @Email(message = "Invalid email")
    private String email;
    @Size(min = 6, message = "passwored must be at least 6 characters long.")
    private String password;
    @NotNull(message = "passwords do not match")
    private String verifypassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifypassword = verifypassword;
    }

    public @NotNull String getVerifypassword() {
        return verifypassword;
    }

    public void setVerifypassword(String verifypassword) {
        this.verifypassword = verifypassword;
        checkPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;

    }

    public void checkPassword() {
        if(password !=null && verifypassword != null && !password.equals(verifypassword)) {
            verifypassword = null;
            }

        }


}