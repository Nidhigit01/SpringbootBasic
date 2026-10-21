package com.example.ems.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.repository.EmpRepository;
import com.example.ems.model.Employee;

import java.util.Optional;

import org.springframework.data.domain.*;


@Service
public class EmpService {
    
    private final EmpRepository empRepository;

    @Autowired
    public EmpService(EmpRepository empRepository){
        this.empRepository = empRepository;
    }

    public Page<Employee> getAllWithPagination(Pageable pageable){
        return empRepository.findAll(pageable);
    }

    public Employee getEmployeeById(Long employeeId){
        return empRepository.findById(employeeId).orElse(null);
    }

    public Employee createEmployee(Employee employee){
        return empRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(Long employeeId, Employee employeeDetails){
        Optional<Employee> optionalEmployee = empRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDesignation(employeeDetails.getDesignation());
            employee.setJob(employeeDetails.getJob());
            return Optional.of(empRepository.save(employee));
        }else{
            return Optional.empty();
        }
    }

    public boolean deleteEmployee(Long employeeId){
        Optional<Employee> optionalEmployee = empRepository.findById(employeeId);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            empRepository.delete(employee);
            return true;
        }else{
            return false;
        }
    }

}
