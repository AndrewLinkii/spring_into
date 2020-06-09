package test.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.spring.dto.UserResponseDto;
import test.spring.model.User;
import test.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseDto get(@PathVariable Long userId) {
        return new UserResponseDto();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::getUserDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String inject() {
        userService.add(new User("klop", "11"));
        userService.add(new User("ignat", "22"));
        return "new users was successfully added";
    }

    private UserResponseDto getUserDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
