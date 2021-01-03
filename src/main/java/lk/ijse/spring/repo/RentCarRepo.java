package lk.ijse.spring.repo;

import lk.ijse.spring.dto.RentCarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.CustomerSignIn;
import lk.ijse.spring.entity.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentCarRepo extends JpaRepository<RentCar,Integer> {


}
