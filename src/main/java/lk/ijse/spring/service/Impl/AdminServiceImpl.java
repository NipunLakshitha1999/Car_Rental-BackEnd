package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;


    @Override
    public AdminDTO loginAdmin(AdminDTO dto) {
        Optional<Admin> byId = repo.findById(dto.getEmail( ));
        if(byId.isPresent()){
          return mapper.map(byId.get( ), AdminDTO.class);
        }else {
            throw new  RuntimeException("Invalid ID");
        }
    }
}
