package com.example.davesnewlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /*@Autowired
    RoomRepository roomRepository;*/

    @Autowired
    UserRepository userRepository;

   /* @Autowired
    RoleRepository roleRepository;*/

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
    public String register(){
        return "registration";
    }
}
