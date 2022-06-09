package com.example.justendpoints.controller;

import com.example.justendpoints.exceptions.InfoException;
import com.example.justendpoints.model.PersonalInfo;
import com.example.justendpoints.service.MyServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/users/info")
public class MyController {

    private final MyServiceImpl myService;

    @GetMapping()

    public ResponseEntity<List<PersonalInfo>> getInformationList(){
        try {
            log.info("Incoming request for getting Information");
            return new ResponseEntity<>(myService.getInformationList(), HttpStatus.OK);
        }catch (HttpServerErrorException e){
            log.error("error getting Information");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonalInfo> deleteAllInformation(@PathVariable(value = "id") Long id){
        try{
            log.info("Incoming request for Deleting Information");
            myService.deleteAllInformation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (HttpServerErrorException | InfoException e){
            log.error("error Deleting Information");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
