package test.spring.service;

import java.util.List;
import test.spring.model.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
