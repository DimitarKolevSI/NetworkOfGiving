package com.vmware.NetworkOfGiving.controller;

import com.vmware.NetworkOfGiving.service.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/participate")
public class ParticipateController {

    private final String LOCAL_HOST_URL = "http://localhost:4200";
    private final ParticipateService participateService;

    @Autowired
    public ParticipateController(ParticipateService participateService) {
        this.participateService = participateService;
    }

    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @CrossOrigin(origins = LOCAL_HOST_URL)
    @PostMapping(path = "/{username}/{charityId}")
    public ResponseEntity participateIn(@PathVariable("username") String username, @PathVariable("charityId") int charityId)
    {
        try{
            System.out.println("Participating in: " + charityId);
            participateService.participateIn(username, charityId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
