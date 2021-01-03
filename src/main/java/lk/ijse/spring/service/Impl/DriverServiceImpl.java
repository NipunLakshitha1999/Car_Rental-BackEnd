package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.SetOfDriverSheduleDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public DriverDTO LoginDriver(DriverDTO dto) {
        Optional<Driver> byId = repo.findById(dto.getDriverEmail( ));
        if(byId.isPresent()){
            return mapper.map(byId.get(),DriverDTO.class);
        }else {
            throw  new RuntimeException("Inavlid ID");
        }
    }

    @Override
    public void SaveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverEmail())){
            Driver map = mapper.map(dto, Driver.class);
            repo.save(map);
        }else {
            throw new RuntimeException("This Driver Already Exisits");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = repo.findAll( );
        return mapper.map(all,new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO findDriver(String driverEmail) {
        Optional<Driver> byId = repo.findById(driverEmail);
        if (byId.isPresent()){
            return mapper.map(byId.get(),DriverDTO.class);
        }else {
            throw new RuntimeException("Invalid ID");
        }
    }

    @Override
    public void updateDiverStatus(DriverDTO dto1) {
        if(repo.existsById(dto1.getDriverEmail())){
            Driver map = mapper.map(dto1, Driver.class);
            repo.save(map);
        }else {
            throw new RuntimeException("No such Driver Update");
        }
    }

    @Override
    public List<Object> getAllSheduleByID(String email) {
        List<Object> allSheduleByID = repo.getAllSheduleByID(email);
        return allSheduleByID;
    }
}
