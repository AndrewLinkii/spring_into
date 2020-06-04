package test.spring;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.spring.config.AppConfig;
import test.spring.model.User;
import test.spring.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("user1", "1"));
        userService.add(new User("user2", "2"));
        userService.add(new User("user3", "3"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Login: " + user.getLogin());
            System.out.println("Password: " + user.getPassword());
            System.out.println();
        }
    }
}
