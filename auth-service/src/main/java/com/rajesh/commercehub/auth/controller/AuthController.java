package com.rajesh.commercehub.auth.controller;

import com.rajesh.commercehub.auth.entity.User;
import com.rajesh.commercehub.auth.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

   private Map<String, String> users = new HashMap<>();

   @PostMapping("/register")
   public String register(@RequestBody User user){
       users.put(user.getUsername(), user.getPassword());
       return "User Registered";

   }

   @PostMapping("/login")
   public String login(@RequestBody User user){

       String storedPassword = users.get(user.getUsername());

       if(storedPassword != null && storedPassword.equals(user.getPassword())){

           String token = JwtUtil.generateToken(user.getUsername());

           return token;
       }
       return "Invalid Credentials";
   }

}
