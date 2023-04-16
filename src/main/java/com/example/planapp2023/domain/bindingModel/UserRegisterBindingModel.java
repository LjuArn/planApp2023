package com.example.planapp2023.domain.bindingModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    private String username;
    @NotEmpty
    @Email(message = "Email cannot be empty")
    private String email;
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}


//•	Has a Username (unique, not null)
//o	Username length must be between 3 and 20 characters (inclusive of 3 and 20).
//•	Has a Password (not null)
//o	Password length must be between 3 and 20 characters (inclusive of 3 and 20).
//•	Has an Email (unique, not null)
//o	Must contain '@'.