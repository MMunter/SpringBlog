package com.codeup.teddyblog.repositories;

import com.codeup.teddyblog.Models.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long>{

    @Query("select age from Dog")
    public List<Integer> getAges();

    @Transactional
    public void deleteById(long id);
}
