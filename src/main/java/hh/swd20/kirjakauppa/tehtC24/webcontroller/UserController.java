package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "login"; //login.html
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login"; //login.html
    }
}
