package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerSignInDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto){
        System.out.println(dto);
        BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder( );
        String encode = PasswordEncoder.encode(dto.getPassword( ));
        CustomerDTO dto1=new CustomerDTO(dto.getEmail(),dto.getNic(),dto.getLisenNo(),dto.getName(),dto.getAddress(),dto.getContact(),encode);

        customerService.saveCustomer(dto1);
        return new ResponseEntity(new StandedResponse(200, "Success", null), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path = "/signIn")
    public ResponseEntity customerSignIn(@RequestBody CustomerDTO dto){
        System.out.println(dto );
        CustomerDTO password = customerService.findPassword(dto.getEmail( ));
        BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder( );
        boolean match = PasswordEncoder.matches(dto.getPassword(),password.getPassword());
        System.out.println(match);
        if (match){
            return new ResponseEntity(new StandedResponse(200,"Success",null),HttpStatus.OK);
        }else {
            return new ResponseEntity(new StandedResponse(300,"fail",null),HttpStatus.EXPECTATION_FAILED);
        }
    }


}
