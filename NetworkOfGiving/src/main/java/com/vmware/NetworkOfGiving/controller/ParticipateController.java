package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.service.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/participate")
public class ParticipateController {

    private final ParticipateService participateService;

    @Autowired
    public ParticipateController(ParticipateService participateService) {
        this.participateService = participateService;
    }

    @PostMapping(path = "/{username}/{charityId}")
    public void participateIn(@PathVariable("username") String username, @PathVariable("charityId") int charityId)
    {
        participateService.participateIn(username, charityId);
    }
}
