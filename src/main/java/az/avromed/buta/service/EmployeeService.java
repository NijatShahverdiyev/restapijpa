package az.avromed.buta.service;

import az.avromed.buta.request.ReqEmployee;
import az.avromed.buta.entity.Department;
import az.avromed.buta.entity.Employee;
import az.avromed.buta.dao.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> employeeList() {
        return  employeeRepo.findAll();
    }

    public boolean saveEmployee(ReqEmployee reqEmployee) {
        Employee employee = new Employee();
        if (reqEmployee.getName() == null || reqEmployee.getSurname() == null || reqEmployee.getPhone() == null || reqEmployee.getDepartmentId() == 0)
            return false;
        Department department=new Department();
        department.setId(reqEmployee.getDepartmentId());
        employee.setName(reqEmployee.getName());
        employee.setSurname(reqEmployee.getSurname());
        employee.setPatronymics(reqEmployee.getPatronymics());
        employee.setPhone(reqEmployee.getPhone());
        employee.setSecondPhone(reqEmployee.getSecondPhone());
        employee.setDepartment(department);
        employeeRepo.save(employee);
        return true;
    }

}
