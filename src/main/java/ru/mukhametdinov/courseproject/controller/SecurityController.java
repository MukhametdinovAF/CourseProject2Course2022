package ru.mukhametdinov.courseproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mukhametdinov.courseproject.dto.UserDto;
import ru.mukhametdinov.courseproject.entity.User;
import ru.mukhametdinov.courseproject.service.UserActionsService;
import ru.mukhametdinov.courseproject.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SecurityController {

    private UserService userService;
    @Autowired
    private UserActionsService userActionsService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showregistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        userActionsService.savelog("Show registration form");
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "На этот адрес электронной почты уже зарегистрирована учетная запись");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        userActionsService.savelog("Registering a new user");
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        userActionsService.savelog("Show all users");
        return "users";
    }

}
