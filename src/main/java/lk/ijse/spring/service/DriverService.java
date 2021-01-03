package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.SetOfDriverSheduleDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverService {
    DriverDTO LoginDriver(DriverDTO dto);
    void SaveDriver(DriverDTO dto);
    List<DriverDTO> getAllDrivers();
    DriverDTO findDriver(String driverEmail);
    void updateDiverStatus(DriverDTO dto1);
    List<Object> getAllSheduleByID(String email);
}
