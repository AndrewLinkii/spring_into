package test.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import test.spring.dao.UserDao;
import test.spring.model.User;
import test.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
