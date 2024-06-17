package com.naveen.emsbackend.controller;

import com.naveen.emsbackend.dto.EmployeeDTO;
import com.naveen.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployeeDTO = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmpById(@PathVariable Long employeeId,
                                                     @RequestBody EmployeeDTO employeeDTO)
    {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeId, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted with id %s".formatted(employeeId));
    }
}
