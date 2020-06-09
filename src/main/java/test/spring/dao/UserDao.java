package test.spring.dao;

import java.util.List;
import test.spring.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);
}
