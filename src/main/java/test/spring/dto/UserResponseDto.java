package test.spring.dto;

import test.spring.model.User;

public class UserResponseDto {
    private String login;
    private String password;

    public UserResponseDto() {
    }

    public UserResponseDto(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
