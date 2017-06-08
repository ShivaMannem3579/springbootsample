package com.mastercard.example.springbootsample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by e056441 on 6/7/2017.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> findByLastName(String lastName);
}
