package com.sandeeprai.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeeprai.reactive.model.Employee;
import com.sandeeprai.reactive.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService service;

	@GetMapping
	Flux<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
}
