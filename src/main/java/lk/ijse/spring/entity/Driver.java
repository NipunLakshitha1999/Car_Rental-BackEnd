package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver implements Serializable {

    @Id
    private String driverEmail;
    private String driverCode;
    private String driverName;
    private String diverAddress;
    private String diverContact;
    private String status;

    public Driver(String driverEmail, String driverCode) {
        this.driverEmail = driverEmail;
        this.driverCode = driverCode;
    }


    @OneToMany(mappedBy = "driver")
    private List<RentCarDetail> details;
}
