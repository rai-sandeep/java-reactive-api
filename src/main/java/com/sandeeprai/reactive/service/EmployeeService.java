package com.sandeeprai.reactive.service;

import org.springframework.stereotype.Service;

import com.sandeeprai.reactive.model.Employee;
import com.sandeeprai.reactive.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository repo;
	
	public Flux<Employee> getAllEmployees(){
		return repo.getAllEmployees();
	}
}
