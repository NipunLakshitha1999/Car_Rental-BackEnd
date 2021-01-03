package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.dto.RentCarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.CustomerSignIn;
import lk.ijse.spring.entity.RentCar;
import lk.ijse.spring.repo.RentCarRepo;
import lk.ijse.spring.service.RentCarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentCarServiceImpl implements RentCarService {

    @Autowired
    RentCarRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void rentCar(RentCarDTO dto) {
        RentCar map = mapper.map(dto, RentCar.class);
        repo.save(map);
    }

    @Override
    public List<RentCarDTO> getAllRentDeatil() {
        List<RentCar> all = repo.findAll( );

        return mapper.map(all,new TypeToken<List<RentCarDTO>>(){}.getType());
    }

    @Override
    public RentCarDTO findRentRecode(int id) {
        Optional<RentCar> byId = repo.findById(id);
        if(byId.isPresent()){
            return mapper.map(byId.get(),RentCarDTO.class);
        }else {
            throw new RuntimeException("Invalid id");
        }

    }


}
