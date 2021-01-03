package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerSignIn;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo  repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(!repo.existsById(dto.getEmail())){
            Customer map = mapper.map(dto, Customer.class);
            System.out.println(map);
            repo.save(map);
        }else {
            throw new RuntimeException("Can not save this customer");
        }
    }

    @Override
    public CustomerDTO findPassword(String email) {
        Optional<Customer> byId = repo.findById(email);
        System.out.println(byId);
        if(byId.isPresent()){
            return mapper.map(byId.get(),CustomerDTO.class);
        }else {
            throw  new RuntimeException("Invalid ID");
        }
    }

    @Override
    public CustomerDTO findCustomer(String email) {
        Optional<Customer> byId = repo.findById(email);

        return mapper.map(byId.get(),CustomerDTO.class);

    }

}
