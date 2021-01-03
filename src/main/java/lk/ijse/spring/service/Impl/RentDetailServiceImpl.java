package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.RentDetailDTO;
import lk.ijse.spring.entity.RentCarDetail;
import lk.ijse.spring.repo.RentDetailRepo;
import lk.ijse.spring.service.RentCarDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentDetailServiceImpl implements RentCarDetailService {

    @Autowired
    RentDetailRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addRentDetail(RentDetailDTO dto) {
        RentCarDetail map = mapper.map(dto, RentCarDetail.class);
        repo.save(map);
    }

    @Override
    public List<RentDetailDTO> getAllDetail() {
        List<RentCarDetail> all = repo.findAll( );
         return mapper.map(all,new TypeToken<List<RentDetailDTO>>(){}.getType());
    }
}
