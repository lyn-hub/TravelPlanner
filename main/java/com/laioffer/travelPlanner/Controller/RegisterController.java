package com.laioffer.travelPlanner.Controller;

import com.laioffer.travelPlanner.Service.UserService;
import com.laioffer.travelPlanner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping (value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationForm() {
        User user = new User();
        return new ModelAndView("register", "user", user);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }
        userService.addUser(user);
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
