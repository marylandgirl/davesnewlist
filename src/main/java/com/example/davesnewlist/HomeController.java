package com.example.davesnewlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class HomeController {
/*

    @Autowired
    RoomRepository roomRepository;
*/

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String home(){
        return "homepage";
    }
    @RequestMapping("/index")
    public String showRooms(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping("/registration")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
       /* System.out.println("Kim there are " + result.hasErrors() + " errors");*/
        if (result.hasErrors()){
            return "/login";
        }
        System.out.println("Kim this is the user name " + user.getUsername());
        Role r = roleRepository.findByRole("USER");
        userRepository.save(user);
        System.out.println("Kim status of getting geekgirl is  " + userRepository.findByUsername("geekgirl"));;
        /*return "redirect:/homepage";*/
        return "/homepage";
    }


}
