package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getLogin(Model model){
        User user=new User();
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    public String Login(@ModelAttribute User user, HttpSession session) {
        User userBd=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
          if(userBd!=null){
            session.setAttribute("user",userBd.getId());
            return "test";
        }
        else{
            return"redirect:/";
        }
    }
}
