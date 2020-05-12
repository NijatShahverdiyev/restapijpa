package az.avromed.buta.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends BasicEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buta_employee_SEQ")
    @SequenceGenerator(sequenceName = "buta_employee_seq", allocationSize = 1, name = "buta_employee_SEQ")
    private Long id;
    private String name;
    private String surname;
    private String patronymics;
    private String phone;
    private String secondPhone;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "id")
    private Department department;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars;

}
