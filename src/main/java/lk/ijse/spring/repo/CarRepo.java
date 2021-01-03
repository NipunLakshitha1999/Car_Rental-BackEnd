package lk.ijse.spring.repo;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    @Query(value = "select * from car where no like 'MiniCar%'",nativeQuery = true)
    List<Car> getAllMiniCars();

    @Query(value = "select * from car where no like 'Hybrid%'",nativeQuery = true)
    List<Car> getAllHybridCars();

    @Query(value = "select * from car where no like 'Primium%'",nativeQuery = true)
    List<Car> getAllPrimiyumCars();

    @Query(value = "select * from car where no like 'Luxury%'",nativeQuery = true)
    List<Car> getAllLuxuryCars();

    @Query(value = "select * from car where no like 'MiniVan%'",nativeQuery = true)
    List<Car> getAllMiniVanCars();

    @Query(value = "select * from car where no like 'Van%'",nativeQuery = true)
    List<Car> getAllVanCars();
}
