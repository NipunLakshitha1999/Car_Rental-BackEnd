package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String id);
    List<CarDTO> getAllMiniCarsDetail();
    List<CarDTO> getAllHybridCarsDetail();
    List<CarDTO> getAllPrmiyumCarsDetail();
    List<CarDTO> getAllLuxuryCarsDetail();
    List<CarDTO> getAllMiniVanCarsDetail();
    List<CarDTO> getAllvanCarsDetail();

    CarDTO getCarDetail(String regNo);

    CarDTO findCar(String regno);
}
