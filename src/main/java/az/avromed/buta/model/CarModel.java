package az.avromed.buta.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "carModel")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carModel_SEQ")
    @SequenceGenerator(sequenceName = "carModel_seq", allocationSize = 1, name = "carModel_SEQ")
    private Long id;
    private String name;
    private Date createDate;
    private boolean active;

    public CarModel() {
    }

    public CarModel(String name, Date createDate, boolean active) {
        this.name = name;
        this.createDate = createDate;
        this.active = active;
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
}
