package com.sandeeprai.reactive.config;

import org.davidmoten.rx.jdbc.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Db2Config {

    @Bean
    public Database database() {
        return Database.nonBlocking()
                .url("jdbc:db2://localhost:50000/testdb:currentSchema=DB2INST1;")
                .user("db2inst1")
                .password("testpass")
                .maxPoolSize(25)
                .build();
        //DB2 DB for local testing can be created as follows:
        //docker run -itd --name db2 -e DBNAME=testdb -e DB2INST1_PASSWORD=testpass -e LICENSE=accept -p 50000:50000 --privileged=true ibmcom/db2
        //CREATE TABLE EMPLOYEE(ID INTEGER NOT NULL, NAME CHAR (30));
        //INSERT INTO DB2INST1.EMPLOYEE (ID, NAME) VALUES(10, 'James Bond');     
        //INSERT INTO DB2INST1.EMPLOYEE (ID, NAME) VALUES(20, 'Harry Potter');     
        //INSERT INTO DB2INST1.EMPLOYEE (ID, NAME) VALUES(30, 'Bruce Wayne');
    }
}
