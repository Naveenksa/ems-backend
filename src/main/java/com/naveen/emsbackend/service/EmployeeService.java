package com.naveen.emsbackend.service;

import com.naveen.emsbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDto);

    EmployeeDTO getEmployee(Long empId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long empId, EmployeeDTO updatedEmps);

    void deleteEmployee(Long employeeId);

}
