package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/adminSignIn")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public boolean loginAdmin(@RequestBody AdminDTO dto){

        BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder( );

        AdminDTO adminDTO = service.loginAdmin(dto);
        boolean match = PasswordEncoder.matches(dto.getPassowrd( ), adminDTO.getPassowrd( ));
        return match;
    }
}
