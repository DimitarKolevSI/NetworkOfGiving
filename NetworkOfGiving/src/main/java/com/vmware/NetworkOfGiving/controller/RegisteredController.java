package com.vmware.NetworkOfGiving.controller;


import com.vmware.NetworkOfGiving.model.Registered;
import com.vmware.NetworkOfGiving.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registered")
public class RegisteredController {
    private final String LOCAL_HOST_URL = "http://localhost:4200";
    private final RegisteredService registeredService;

    @Autowired
    public RegisteredController(RegisteredService registeredService) {
        this.registeredService = registeredService;
    }

    @CrossOrigin
    @GetMapping(path = "/all")
    public List<Registered> getAllRegistered()
    {
        return registeredService.getAllRegistered();
    }

    @CrossOrigin
    @GetMapping(path = "/get/{username}")
    public Registered getRegisteredByUsername(@PathVariable("username") String username){
        return registeredService.getRegisteredByUsername(username);
    }

    @CrossOrigin(origins = LOCAL_HOST_URL)
    @PostMapping("/add")
    public void registerUser(@RequestBody Registered registered)
    {
        System.out.println("Creating new user");
        registeredService.registerUser(registered);
    }
}
