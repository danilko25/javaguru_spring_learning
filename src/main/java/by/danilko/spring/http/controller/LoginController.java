package by.danilko.spring.http.controller;

import by.danilko.spring.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping
    public String loginPage(){
        return "user/login";
    }

    @PostMapping
    public String login(Model model, @ModelAttribute("login") LoginDto loginDto){
        return "redirect:/login";
    }
}
