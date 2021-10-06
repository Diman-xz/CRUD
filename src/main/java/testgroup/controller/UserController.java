package testgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.model.User;
import testgroup.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("allUsers", userService.allUser());
        return "users";
    }

    @GetMapping(value = "/users/newUser")
    public String newUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        return "newUser";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping(value = "/editUser")
    public String editUser(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.remove(id);
        return "redirect:/users";
    }
}
