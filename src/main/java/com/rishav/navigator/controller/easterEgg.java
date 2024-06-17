package com.rishav.navigator.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;





@RestController
@RequestMapping("/hidden-feature")
public class easterEgg {


    @GetMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    public String getExam(@PathVariable long number){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://numbersapi.com/" + number;
        String fact = restTemplate.getForObject(url, String.class);
        return fact;
    }

}
