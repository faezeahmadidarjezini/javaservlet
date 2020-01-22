package model.service;


import model.entity.Person;

import java.util.List;

/**
 * Created by AmirBahador on 12/17/2018.
 */
public interface PersonService {
     void save(Person person) throws Exception ;

     void update(Person person) throws Exception ;

     void delete(String username) throws Exception;

     List<Person> get() throws Exception;
     Person check(Person person)throws Exception;
}
