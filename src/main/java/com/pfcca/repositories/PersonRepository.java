package com.pfcca.repositories;

import com.pfcca.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
    public Person findById(@Param("id") String id);
    public List<Person> findByFirstName(@Param("firstName") String firstName);
    public List<Person> findByLastName(@Param("lastName") String lastName);
    public Person findByUsername(@Param("username") String username);
}
