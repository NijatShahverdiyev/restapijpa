package az.avromed.buta.service;

import az.avromed.buta.request.ReqDepartment;
import az.avromed.buta.entity.Department;
import az.avromed.buta.dao.DepartmentRepo;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> departmentList() {
        List<Department> departmentList = departmentRepo.findAll();
        if (departmentList.size() > 0)
            return departmentList;
        else
            return new ArrayList<>();
    }

    public Department saveDepartment(ReqDepartment reqDepartment) {
        Department department = null;
        try {
            if (reqDepartment.getName() != null) {
                department = new Department();
                department.setName(reqDepartment.getName());
                departmentRepo.save(department);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return department;
    }

    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepo.findById(departmentId);
    }

    public Department updateDepartment(ReqDepartment reqDepartment) {
        Department department = null;
        try {
            if (reqDepartment.getName() != null) {
                department = new Department();
                department.setName(reqDepartment.getName());
                department.setUpdated(new Date());
                department.setId(reqDepartment.getId());
                departmentRepo.save(department);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return department;
    }

    public boolean deleteDepartment(Long departmentId) {
        try {
            departmentRepo.deleteById(departmentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}

