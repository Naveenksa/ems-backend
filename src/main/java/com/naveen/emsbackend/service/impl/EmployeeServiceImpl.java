package com.naveen.emsbackend.service.impl;

import com.naveen.emsbackend.dto.EmployeeDTO;
import com.naveen.emsbackend.entity.Employee;
import com.naveen.emsbackend.exception.ResourceNotFoundException;
import com.naveen.emsbackend.mapper.EmployeeMapper;
import com.naveen.emsbackend.repository.EmployeeRepository;
import com.naveen.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {

        Employee employee = EmployeeMapper.mapToEmp(employeeDto);
        Employee savedemp = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmpoyeeDto(savedemp);
    }

    @Override
    public EmployeeDTO getEmployee(Long empId) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not not by given id :_  " + empId));
        return EmployeeMapper.mapToEmpoyeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map((emps) -> EmployeeMapper.mapToEmpoyeeDto(emps))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO updatedEmps) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("employe not exist for given id:-" + empId));

        employee.setFirstName(updatedEmps.getFirstName());
        employee.setLastName(updatedEmps.getLastName());
        employee.setEmail(updatedEmps.getEmail());
        Employee updatedEmpObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmpoyeeDto(updatedEmpObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employe not exist for given id:-" + employeeId));
        employeeRepository.deleteById(employeeId);
    }

}
