package az.avromed.buta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car extends BasicEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_SEQ")
    @SequenceGenerator(sequenceName = "car_seq", allocationSize = 1, name = "car_SEQ")
    private Long id;
    private String serialNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false,referencedColumnName = "id")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_model_id", nullable = false,referencedColumnName = "id")
    private CarModel carModel;
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarDetail> carDetails;

}
