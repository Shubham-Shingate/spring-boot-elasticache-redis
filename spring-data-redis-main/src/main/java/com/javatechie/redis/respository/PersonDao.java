package com.javatechie.redis.respository;

import com.javatechie.redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {

    public static final String HASH_KEY = "Person";
    
    @Autowired
    private RedisTemplate template;

    public Person save(Person person){
        template.opsForHash().put(HASH_KEY,person.getId(),person);
        return person;
    }

    public List<Person> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Person findPersonById(int id){
        return (Person) template.opsForHash().get(HASH_KEY,id);
    }

    public String deletePerson(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "Person removed !!";
    }
}
