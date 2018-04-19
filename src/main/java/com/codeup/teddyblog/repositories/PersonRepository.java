package com.codeup.teddyblog.repositories;

import com.codeup.teddyblog.Models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value="select age from people", nativeQuery = true)
    public List<Integer> getAges();
}
