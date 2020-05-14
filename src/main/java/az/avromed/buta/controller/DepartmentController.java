package az.avromed.buta.controller;

import az.avromed.buta.exceptions.ErrorDetails;
import az.avromed.buta.exceptions.GlobalExceptionHandler;
import az.avromed.buta.exceptions.ResourceExceptions;
import az.avromed.buta.request.ReqDepartment;
import az.avromed.buta.entity.Department;
import az.avromed.buta.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class DepartmentController extends GlobalExceptionHandler {
    private DepartmentService departmentService;

    @GetMapping(value = "/departments",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Department>> departments() {
        return new ResponseEntity<>(departmentService.departmentList(), HttpStatus.OK);
    }

    @PostMapping(value = "/addDepartment",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Department> addDepartment(@RequestBody ReqDepartment reqDepartment,WebRequest request) throws ResourceExceptions {
        Department department = departmentService.saveDepartment(reqDepartment);
        if (department ==null)
          throw new ResourceExceptions("Add Failed, 'name: null'");
        return ResponseEntity.ok().body(department);
    }

    @GetMapping("/getDepartmentById/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long departmentId)  throws ResourceExceptions {
        Department department=departmentService.getDepartmentById(departmentId)
                .orElseThrow(()-> new ResourceExceptions("Department not found for this id: "+departmentId));
        return ResponseEntity.ok().body(department);
    }


    @PutMapping(value = "/updateDepartment",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity updateDepartment(@RequestBody ReqDepartment reqDepartment) throws ResourceExceptions {
        if (!departmentService.getDepartmentById(reqDepartment.getId()).isPresent())
            throw new ResourceExceptions("Department not found for this id: "+reqDepartment.getId());
        else if (departmentService.updateDepartment(reqDepartment)==null)
            throw new NullPointerException("Department name: "+reqDepartment.getName());
        //departmentService.updateDepartment(reqDepartment);
        return ResponseEntity.ok().body(departmentService.updateDepartment(reqDepartment));
    }

    @DeleteMapping("/deleteDepartment/{departmentId}")
    public Map<String,Boolean> deleteDepartment(@PathVariable Long departmentId) throws ResourceExceptions {
        Department department=departmentService.getDepartmentById(departmentId)
                .orElseThrow(()-> new ResourceExceptions("Department not found for this id: "+departmentId));
        departmentService.deleteDepartment(departmentId);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }
}
