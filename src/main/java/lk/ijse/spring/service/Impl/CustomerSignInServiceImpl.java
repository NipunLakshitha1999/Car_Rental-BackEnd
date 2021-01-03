package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerSignIn;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.CustomerSignInRepo;
import lk.ijse.spring.service.CustomerSignInSevice;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerSignInServiceImpl implements CustomerSignInSevice {


    @Autowired
    CustomerSignInRepo repo;

    @Autowired
    ModelMapper mapper;

}
