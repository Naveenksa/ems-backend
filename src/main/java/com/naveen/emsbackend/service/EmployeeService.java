package com.naveen.emsbackend.service;

import com.naveen.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto creatEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmpById(Long empId);

    List<EmployeeDto> getAllEmps();

    EmployeeDto upDateEmployee(Long empId,EmployeeDto updatedEmps);

    void deleteEmps(Long empsId);

}
