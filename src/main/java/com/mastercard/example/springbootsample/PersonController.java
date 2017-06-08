package com.mastercard.example.springbootsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by e056441 on 6/7/2017.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getAllPersons(){
        return new ResponseEntity<>((Collection<Person>) personRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{lastName}")
    public ResponseEntity getPersonWithLastName(@PathVariable String lastName) {
        return new ResponseEntity<>((Collection<Person>) personRepository.findByLastName(lastName),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }
}
