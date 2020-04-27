package az.avromed.buta.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_SEQ")
    @SequenceGenerator(sequenceName = "department_seq", allocationSize = 1, name = "department_SEQ")
    private Long id;
    private String name;
    private Date createDate;
    private boolean active;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department(String name, Date createDate, boolean active, List<Employee> employees) {
        this.name = name;
        this.createDate = createDate;
        this.active = active;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isActive() {
        return active;
    }

    public List<Employee> getEmployee() {
        return employees;
    }
}
