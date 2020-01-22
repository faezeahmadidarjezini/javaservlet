package model.service;

import model.entity.Person;
import model.repository.PersonDA;

import java.util.List;

/**
 * Created by AmirBahador on 12/17/2018.
 */
public class PersonServiceImpl implements PersonService {
    private static PersonServiceImpl personServiceImpl = new PersonServiceImpl();

    private PersonServiceImpl() {
    }

    public static PersonServiceImpl getInstance() {
        return personServiceImpl;
    }

    public void save(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();
    }

    public void update(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.update(person);
        personDA.close();
    }

    public void delete(String username) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.delete(username);
        personDA.close();
    }


    public List<Person> get() throws Exception {
        PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.select();
        personDA.close();
        return personList;
    }
    public Person check(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.select();
        for (Person person1 : personList) {
            if (person1.equals(person)) {
                return person;
            }
        }
        return null;
    }
}
