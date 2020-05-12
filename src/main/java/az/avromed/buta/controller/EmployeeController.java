package az.avromed.buta.controller;

import az.avromed.buta.request.ReqEmployee;
import az.avromed.buta.entity.Employee;
import az.avromed.buta.service.DepartmentService;
import az.avromed.buta.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/employeeList")
    public ResponseEntity employeeList() {
        List<Employee> employeeList = employeeService.employeeList();
        if (employeeList.size() > 0)
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/saveEmployee")
    public @ResponseBody
    ResponseEntity saveEmployee(@RequestBody ReqEmployee reqEmployee) {
        System.out.println(reqEmployee);
        ResponseEntity responseEntity;
        if (!employeeService.saveEmployee(reqEmployee)) {
            responseEntity = new ResponseEntity<>("Internal Exception", HttpStatus.BAD_REQUEST);
        } else
            responseEntity = new ResponseEntity<>(reqEmployee, HttpStatus.OK);

        return responseEntity;
    }
}
