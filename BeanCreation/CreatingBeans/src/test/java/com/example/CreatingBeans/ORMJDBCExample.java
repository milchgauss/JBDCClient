package com.example.CreatingBeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ORMJDBCExample implements CommandLineRunner {

    //Following the  Baeldung Tutorial
    private static final Logger log= LoggerFactory.getLogger(ORMJDBCExample.class);

    public static void main(String[]args){
        SpringApplication.run(ORMJDBCExample.class,args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {
    // Code for the JBDC template here.
        //YOu can also execute SQL queries and edit your database from here!

        jdbcTemplate.execute("DROP TABLE customerlogin IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customerlogin("+
                "id CUSTOMERID, FirstName VARCHAR(255), LastName VARCHAR(255), Email VARCHAR(255)");

        //Returns an array object of all the names.
        //Uses the split() method to recognize the " " between the first and last name
        //Uses collectors to transform in to list.

        List<Object[]> namesAre=
                Arrays.asList("Name1 Name2","Name1 Name2",
                        "Name1 Name2","Name1 Name2").stream()
                        .map(name-> name.split(" "))
                        .collect(Collectors.toList());

        namesAre.forEach(name->log.info(String.format("Insert here"+ name[0]+name[1])));
        //Remember to use (?,?) prepared statements to prevent SQL injection!

        jdbcTemplate.batchUpdate("INSERT INTO customerlogin (FirstName, LastName, Email) VALUES (?,?,?)", namesAre);
        

    }
}
