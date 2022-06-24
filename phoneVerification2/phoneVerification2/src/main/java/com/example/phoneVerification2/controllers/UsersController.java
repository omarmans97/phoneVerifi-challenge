package com.example.phoneVerification2.controllers;

import com.example.phoneVerification2.models.User;
import com.example.phoneVerification2.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        String url = "https://api.numlookupapi.com/v1/validate/"+user.getPhoneNumber()+"?apikey=7dsu4ElmdrqTab6FAkEuZoGCd6Z9eCcJhLHxqRCa";
        RestTemplate restTemplate = new RestTemplate();
        Map<String ,String > map = new HashMap<>();
        map = restTemplate.getForObject(url,Map.class);
        user.setCarrier(map.get("carrier"));
        user.setCountryCode(map.get("country_code"));
        user.setCountryName(map.get("country_name"));
        if(String.valueOf(map.get("valid")).equals("true"))
            user.setValid(true);
        usersService.createUser(user);
        return user;
    }


    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable UUID id){
       return usersService.deleteUser(id);
    }

    @GetMapping("/findAll")
    public List<User> findAllUsers(){
        return usersService.findAllUsers();
    }

    @GetMapping("/findById/{id}")
    public User findUserById(@PathVariable UUID id){
        return usersService.findUserById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return usersService.updateUser(user);
    }

}
