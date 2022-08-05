package com.sandeeprai.reactive.repository;

import org.davidmoten.rx.jdbc.Database;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sandeeprai.reactive.model.Employee;

import io.reactivex.Flowable;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final Database database;

    public Flux<Employee> getAllEmployees() {
        String sql = "SELECT * FROM EMPLOYEE";

        Flowable<Employee> employeeFlowable = 
                database.select(sql).get(rs -> {
                    return Employee.builder()
                            .id(rs.getInt("id"))
                            .name(StringUtils.trimWhitespace(rs.getString("name")))
                            .build();
        });

        return Flux.from(employeeFlowable);
    }
}
