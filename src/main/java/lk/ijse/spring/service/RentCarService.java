package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.dto.RentCarDTO;
import lk.ijse.spring.entity.CustomerSignIn;

import java.util.List;

public interface RentCarService {
    void rentCar(RentCarDTO dto);
    List<RentCarDTO> getAllRentDeatil();
    RentCarDTO findRentRecode(int id);


}
