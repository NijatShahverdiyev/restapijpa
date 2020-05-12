package az.avromed.buta.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReqEmployee {
    private String name;
    private String surname;
    private String patronymics;
    private String phone;
    private String secondPhone;
    private Long departmentId;
}
