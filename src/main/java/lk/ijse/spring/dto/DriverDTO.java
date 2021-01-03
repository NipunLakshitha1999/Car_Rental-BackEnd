package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private String driverEmail;
    private String driverCode;
    private String driverName;
    private String diverAddress;
    private String diverContact;
    private String status;

    public DriverDTO(String driverEmail, String driverCode) {
        this.driverEmail = driverEmail;
        this.driverCode = driverCode;
    }

    public DriverDTO(String driverEmail, String driverName, String status) {
        this.driverEmail = driverEmail;
        this.driverName = driverName;
        this.status = status;
    }
}
