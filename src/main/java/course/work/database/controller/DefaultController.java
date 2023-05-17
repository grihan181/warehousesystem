package course.work.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    private static final String jwtTokenCookieName = "Bearer";
    @GetMapping("/login")
    public String login() {
        return "/login";
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

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

/*    @PostMapping("/api/logout")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
       // httpServletRequest.set
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }*/
}
