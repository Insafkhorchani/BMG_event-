package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }
    @PostMapping("/signUp")
    public String saveNewAgent(Model model, @ModelAttribute @Valid User user , BindingResult bindingResult, HttpSession session) {
        User userTelExist=  userRepository.findByTel(user.getTel());
        User userEmailExists=userRepository.findByEmail(user.getEmail());
        if(userEmailExists !=null || userTelExist!=null|| bindingResult.hasErrors()) {
            if (userEmailExists != null) {

                model.addAttribute("EmailExist","EmailExist");
            }
            if (userTelExist != null) {

                model.addAttribute("NumTelExist");
            }
            return "signUp";
        }
        userRepository.save(user) ;
        session.setAttribute("user",user);
        return "redirect:/home";
    }


}