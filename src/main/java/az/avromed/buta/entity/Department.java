package az.avromed.buta.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SQLDelete(sql = "UPDATE DEPARTMENT SET ACTIVE=1 WHERE ID=?")
//@Where(clause = "active=1")
public class Department extends BasicEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_SEQ")
    @SequenceGenerator(sequenceName = "department_seq", allocationSize = 1, name = "department_SEQ")
    private Long id;
    @Column(nullable = false)
    private String name;
}
