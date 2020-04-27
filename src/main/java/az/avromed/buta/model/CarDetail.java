package az.avromed.buta.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "carDetail")
public class CarDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carDetail_SEQ")
    @SequenceGenerator(sequenceName = "carDetail_seq", allocationSize = 1, name = "carDetail_SEQ")
    private Long id;
    private String notes;
    private Date createDate;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
