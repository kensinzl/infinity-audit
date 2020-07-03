package nz.co.indepth.infinity.controller;

import nz.co.indepth.infinity.po.EmployeePO;
import nz.co.indepth.infinity.serviceimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<EmployeePO> createMovie(@RequestBody EmployeePO employeePO) {
        EmployeePO createdEmployeePO = employeeService.createEmployee (employeePO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployeePO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeePO>> fetchEmployeePage() {
        List<EmployeePO> result = employeeService.getEmployees ();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public String deleteMovie(@RequestBody EmployeePO employeePO) {
        return employeeService.deleteEmployee (employeePO);
    }
}