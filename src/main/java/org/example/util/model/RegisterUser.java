package org.example.util.model;

public class RegisterUser extends LoginUser {
    String name;
    String confirmPassword;

    public RegisterUser(String name, String email, String password, String confirmPassword) {
        super(email, password);
        this.name = name;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public String toString() {
        return "RegisterUserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
