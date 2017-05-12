package com.mastercard.example.springbootsample;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e056441 on 5/11/2017.
 */

@RestController
public class AdultController {

    @RequestMapping("/check/{age}")
    public String checkAdult(@PathVariable("age") int age) {
        if(age > 18)
            return "Yes, Person is Adult";
        else
            return "No, Person is not an Adult";
    }

}
