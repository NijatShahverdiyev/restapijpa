package az.avromed.buta.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_SEQ")
    @SequenceGenerator(sequenceName = "employee_seq", allocationSize = 1, name = "employee_SEQ")
    private Long id;
    private String name;
    private String surname;
    private String patronymics;
    private String phone;
    private String secondPhone;
    private Date createDate;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
    private Department department;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Car car;
    public Employee() {
    }

    public Employee(Long id, String name, String surname, String patronymics, String phone, String secondPhone, Date createDate, boolean active, Department department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymics = patronymics;
        this.phone = phone;
        this.secondPhone = secondPhone;
        this.createDate = createDate;
        this.active = active;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymics() {
        return patronymics;
    }

    public String getPhone() {
        return phone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isActive() {
        return active;
    }

    public Department getDepartmentId() {
        return department;
    }
}
