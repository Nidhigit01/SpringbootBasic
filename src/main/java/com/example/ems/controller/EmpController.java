package com.example.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.model.Employee;
import com.example.ems.service.EmpService;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("/employees")
public class EmpController {


    private EmpService empService;

    @Autowired 
    public EmpController(EmpService empService){
        this.empService = empService;
    }

    @GetMapping("/all")
    public Page<Employee> getEmployees(@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size,
    @RequestParam(defaultValue = "id") String sortBy,
    @RequestParam(defaultValue = "true") boolean ascending){

        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return empService.getAllWithPagination(pageable);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long id){
        return empService.getEmployeeById(id);
    }

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee){
        return empService.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return empService.updateEmployee(id, employee).orElse(new Employee());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
       boolean bool =  empService.deleteEmployee(id);
       return bool == true ? "Employee is deleted" : "Employee not deleted";
    }
    
}
