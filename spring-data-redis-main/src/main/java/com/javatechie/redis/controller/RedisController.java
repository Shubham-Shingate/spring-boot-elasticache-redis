package com.javatechie.redis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javatechie.redis.entity.Person;
import com.javatechie.redis.respository.PersonDao;

@RestController
@RequestMapping("/person")
public class RedisController {
	
	@Autowired
    private PersonDao dao;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        return dao.save(person);
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return dao.findAll();
    }

    @GetMapping("/findPersonById/{id}")
    public Person findPersonById(@PathVariable int id) {
        return dao.findPersonById(id);
    }
    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id)   {
    	return dao.deletePerson(id);
	}

}
