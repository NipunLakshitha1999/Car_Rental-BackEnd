package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.entity.CustomerSignIn;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO dto);
    CustomerDTO findPassword(String email);
    CustomerDTO findCustomer(String email);
}
