package az.avromed.buta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "car_model")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarModel extends BasicEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_model_SEQ")
    @SequenceGenerator(sequenceName = "car_model_seq", allocationSize = 1, name = "car_model_SEQ")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Car> cars;

}
