package com.naveen.emsbackend.mapper;

import com.naveen.emsbackend.dto.EmployeeDTO;
import com.naveen.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmpoyeeDto(Employee employee) {

        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmp(EmployeeDTO employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
