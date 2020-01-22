package model.repository;


import model.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDA {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/faeze", "root", "1377");
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person  values (?,?,?,?)");
        preparedStatement.setString(1, person.getPassword());
        preparedStatement.setString(2, person.getUsername());
        preparedStatement.setString(3,person.getFirstname());
        preparedStatement.setString(4,person.getLastname());
        preparedStatement.executeUpdate();
    }

    public List<Person> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList();
        while (resultSet.next()) {
            Person person
                    = new Person();
            person.setUsername(resultSet.getString("username"));
            person.setUsername(resultSet.getString("firstname"));
            person.setUsername(resultSet.getString("lastname"));
            person.setPassword(resultSet.getString("password"));
            personList.add(person);
        }
        return personList;
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set password=? , firstname=? , lastname=? where username=?");
        preparedStatement.setString(1, person.getPassword());
        preparedStatement.setString(2, person.getUsername());
        preparedStatement.setString(3,person.getFirstname());
        preparedStatement.setString(4,person.getLastname());
        preparedStatement.executeUpdate();
    }

    public void delete(String username) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person where username=?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}

