package com.naveen.emsbackend.controller;

import com.naveen.emsbackend.dto.EmployeeDto;
import com.naveen.emsbackend.entity.Employee;
import com.naveen.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employess")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Emps to Rest api
    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedempsdto = employeeService.creatEmployee(employeeDto);
        return new ResponseEntity<>(savedempsdto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmp(@PathVariable("id") Long empid) {
        EmployeeDto employeeDto = employeeService.getEmpById(empid);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmps() {
        List<EmployeeDto> employees = employeeService.getAllEmps();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmpById(@PathVariable Long id,
                                                     @RequestBody EmployeeDto updatedEmp)
    {
        EmployeeDto empUpdated = employeeService.upDateEmployee(id, updatedEmp);
        return ResponseEntity.ok(empUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") Long empid){
        employeeService.deleteEmps(empid);
        return ResponseEntity.ok("emp deteled with id "+empid);
    }
}
