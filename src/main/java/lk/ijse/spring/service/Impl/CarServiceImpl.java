package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.RentDetailDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo repo;
    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCar(CarDTO dto) {
        if(!repo.existsById(dto.getNo())){
            Car map = mapper.map(dto, Car.class);
            repo.save(map);
        }else {
            throw  new RuntimeException("Car Already Exist");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if(repo.existsById(dto.getNo())){
            Car map = mapper.map(dto, Car.class);
            repo.save(map);
        }else {
            throw new RuntimeException("No Such a Customer Updated");
        }
    }

    @Override
    public void deleteCar(String id) {
            if (repo.existsById(id)){
                repo.deleteById(id);
            }else {
                throw new RuntimeException("No Car for this ID");
            }
    }

    @Override
    public List<CarDTO> getAllMiniCarsDetail() {
        List<Car> allMiniCars = repo.getAllMiniCars( );

        return mapper.map(allMiniCars,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllHybridCarsDetail() {
        List<Car> allHybridCars = repo.getAllHybridCars( );
        return mapper.map(allHybridCars,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllPrmiyumCarsDetail() {
        List<Car> allPrimiyumCars = repo.getAllPrimiyumCars( );
        return mapper.map(allPrimiyumCars,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllLuxuryCarsDetail() {
        List<Car> allLuxuryCars = repo.getAllLuxuryCars( );
        return mapper.map(allLuxuryCars,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllMiniVanCarsDetail() {
        List<Car> allMiniVanCars = repo.getAllMiniVanCars( );
        return mapper.map(allMiniVanCars,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public List<CarDTO> getAllvanCarsDetail() {
        List<Car> allVanCars = repo.getAllVanCars( );
        return mapper.map(allVanCars,new TypeToken<List<CarDTO>>(){}.getType());
    }

    @Override
    public CarDTO getCarDetail(String regNo) {
        Optional<Car> byId = repo.findById(regNo);
        if(byId.isPresent()){
             return mapper.map(byId.get(),CarDTO.class);
        }else {
            throw new RuntimeException("Invalid ID");
        }
    }

    @Override
    public CarDTO findCar(String regno) {
        Optional<Car> byId = repo.findById(regno);
        if(byId.isPresent()){
            return mapper.map(byId.get(),CarDTO.class);
        }else {
            throw  new RuntimeException("invalid");
        }
    }

}
