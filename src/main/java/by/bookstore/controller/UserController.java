package by.bookstore.controller;

import by.bookstore.entity.User;
import by.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration2(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/authorization")
    public String authorization() {
        return "authorization";
    }

    @PostMapping("/authorization")
    public String authorization2(User user, HttpSession httpSession) {
        User byLogin = userService.getByLogin(user.getLogin());
        if (byLogin.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("user", byLogin);
            return "redirect:/";
        }
        return "authorization";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
       return "redirect:/";
    }
}
