package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerReturnDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.entity.CustomerSignIn;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.CustomerSignInSevice;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/signInCustomer")
@CrossOrigin
public class CustomerSignInController {

    @Autowired
    CustomerSignInSevice sevice;

    @Autowired
    CustomerService customerService;




}
