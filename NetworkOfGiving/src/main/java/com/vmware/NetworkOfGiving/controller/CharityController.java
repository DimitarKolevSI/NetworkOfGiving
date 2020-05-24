package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.model.Charity;
import com.vmware.NetworkOfGiving.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charity")
public class CharityController {

    private final CharityService charityService;

    @Autowired
    public CharityController(CharityService charityService) {
        this.charityService = charityService;
    }

    @PostMapping(path = "/create")
    public void createCharity(@RequestBody Charity charity)
    {
        charityService.createCharity(charity);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCharity(@PathVariable("id") int id)
    {
        charityService.deleteCharity(id);
    }

    @GetMapping(path = "/all")
    public List<Charity> getAllCharities()
    {
        return charityService.getAllCharities();
    }

    @GetMapping(path = "/search/{key}")
    public List<Charity> searchCharity(@PathVariable("key") String key)
    {
        return charityService.searchCharity(key);
    }

}
