package com.vmware.NetworkOfGiving.controller;


import com.vmware.NetworkOfGiving.model.Registered;
import com.vmware.NetworkOfGiving.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registered")
public class RegisteredController {

    private final RegisteredService registeredService;

    @Autowired
    public RegisteredController(RegisteredService registeredService) {
        this.registeredService = registeredService;
    }

    @GetMapping(path = "/all")
    public List<Registered> getAllRegistered()
    {
        return registeredService.getAllRegistered();
    }

    @GetMapping(path = "/get/{username}")
    public Registered getRegisteredByUsername(@PathVariable("username") String username)
    {
        return registeredService.getRegisteredByUsername(username);
    }

    @PostMapping("/add")
    public void registerUser(@RequestBody Registered registered)
    {
        registeredService.registerUser(registered);
    }
}
