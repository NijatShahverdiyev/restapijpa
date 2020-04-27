package az.avromed.buta.dao;

import az.avromed.buta.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ButaRepository extends CrudRepository<Employee,Long> {
    List<Employee> findAll();
    Optional<Employee> findById(Long employeeId);
}
