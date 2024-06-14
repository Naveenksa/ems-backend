package com.naveen.emsbackend.mapper;

import com.naveen.emsbackend.dto.EmployeeDto;
import com.naveen.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmpoyeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmp(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
