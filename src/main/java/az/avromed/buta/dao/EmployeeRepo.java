package az.avromed.buta.dao;

import az.avromed.buta.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    //@Query("SELECT new az.avromed.buta.entity.Employee(E.ID,E.NAME,E.SURNAME,E.PATRONMICS,E.PHONE),new az.avromed.buta.entity.Department(D.NAME) FROM EMPLOYEE JOIN DEPARTMENT D ON E.DEPARTMENT_ID=D.ID")
    List<Employee> findAll();
}
