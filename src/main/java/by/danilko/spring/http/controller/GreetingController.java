package by.danilko.spring.http.controller;

import by.danilko.spring.database.entity.Role;
import by.danilko.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> getRoles(){
        return Arrays.asList(Role.values());
    }

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello/{id}")
    public ModelAndView hello(ModelAndView mv,
                              @RequestParam Integer age, // = @RequestParam("age")
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable("id") Integer id){
        mv.setViewName("greeting/hello");
//        mv.addObject("user", new UserReadDto(1L, "Andrei"));
        return mv;
    }

    @GetMapping(value = "/hello")
    public String hello(Model model,  UserReadDto userReadDto){
        model.addAttribute("user", userReadDto); // Adding user by url parameters(url params named as fields in UserReadDto)
        return "greeting/hello";
    }

    @GetMapping(value = "/bye")
    public String bye(@SessionAttribute("user") UserReadDto user){
        return "greeting/bye";
    }
}
