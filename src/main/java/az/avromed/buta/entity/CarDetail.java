package az.avromed.buta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDetail extends BasicEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_detail_SEQ")
    @SequenceGenerator(sequenceName = "car_detail_seq", allocationSize = 1, name = "car_detail_SEQ")
    private Long id;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
