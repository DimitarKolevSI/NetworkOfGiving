package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.model.Charity;
import com.vmware.NetworkOfGiving.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charity")
public class CharityController {

    private final String LOCAL_HOST_URL = "http://localhost:4200";
    private final CharityService charityService;

    @Autowired
    public CharityController(CharityService charityService) {
        this.charityService = charityService;
    }

    @CrossOrigin(origins = LOCAL_HOST_URL)
    @PutMapping(path = "/create")
    public void createCharity(@RequestBody Charity charity)
    {
        System.out.println("Creating charity");
        charityService.createCharity(charity);
    }

    @CrossOrigin(origins = LOCAL_HOST_URL)
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCharity(@PathVariable("id") int id)
    {
        charityService.deleteCharity(id);
    }

    @CrossOrigin
    @GetMapping(path = "/all")
    public List<Charity> getAllCharities()
    {
        System.out.println("charity/all");
        return charityService.getAllCharities();
    }

    @CrossOrigin
    @GetMapping(path = "/search/{key}")
    public List<Charity> searchCharity(@PathVariable("key") String key)
    {
        return charityService.searchCharity(key);
    }

    @CrossOrigin
    @GetMapping(path = "/get/{title}")
    public Charity getCharityByTitle(@PathVariable("title") String title){
        System.out.println("Searching for: " +title);
        return charityService.getCharityByTitle(title);
    }
}
