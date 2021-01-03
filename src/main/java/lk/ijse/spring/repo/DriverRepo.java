package lk.ijse.spring.repo;

import lk.ijse.spring.dto.SetOfDriverSheduleDTO;
import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "select d.rentDetailid,d.tour,d.carID,d.driverEmail,d.rentID,r.cardate,r.cartime from rentcardetail d, rentcar r where r.rentid=d.rentid and d.driverEmail =?",nativeQuery = true)
    List<Object> getAllSheduleByID(String email);
}
