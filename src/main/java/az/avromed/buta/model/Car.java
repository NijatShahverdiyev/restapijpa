package az.avromed.buta.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_SEQ")
    @SequenceGenerator(sequenceName = "car_seq", allocationSize = 1, name = "car_SEQ")
    private Long id;
    private String serialNumber;
    private Date createDate;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "carModel_id", nullable = false)
    private CarModel carModel;

    private CarDetail carDetail;

    public Car() {
    }

    public Car(String serialNumber, Date createDate, boolean active, Employee employee, CarModel carModel) {
        this.serialNumber = serialNumber;
        this.createDate = createDate;
        this.active = active;
        this.employee = employee;
        this.carModel = carModel;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isActive() {
        return active;
    }

    public Employee getEmployee() {
        return employee;
    }

    public CarModel getCarModel() {
        return carModel;
    }
}
