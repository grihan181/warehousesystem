package course.work.database.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @GetMapping("/login")
    public String login() {
        return "/login.html";
    }
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }
    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("authenticationRequestDTO", new AuthenticationRequestDTO());
        return "login";
    }
}
