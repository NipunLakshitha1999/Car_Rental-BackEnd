package lk.ijse.spring.controller;

import lk.ijse.spring.dto.*;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerSignIn;
import lk.ijse.spring.entity.RentCar;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.RentCarService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rentMiniCar")
@CrossOrigin
public class RentCarController {

    @Autowired
    RentCarService service;

    @Autowired
    CustomerService CusService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity rentMiniCar(@RequestBody RentCarDTO dto){
        System.out.println(dto);
        System.out.println(dto.getCusemail());
        CustomerDTO customer = CusService.findCustomer(dto.getCusemail());
        System.out.println(customer);

        RentCarDTO car=new RentCarDTO(dto.getRentid(),dto.getCarregno(),dto.getCardate(),dto.getCartime(),dto.getCardiver(),customer);
        System.out.println("Rent Car"+car);
        service.rentCar(car);
        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getAllRentDetail(){
        List<RentCarDTO> allRentDeatil = service.getAllRentDeatil( );
        List<RentCarPassDetailDTO> rentDetail=new ArrayList<>();
        for (RentCarDTO r:allRentDeatil) {
            rentDetail.add(new RentCarPassDetailDTO(r.getRentid(),r.getCarregno(),r.getCardate(),r.getCartime(),r.getCardiver(),r.getCustomer().getEmail()));
        }
        System.out.println(allRentDeatil);
        return new ResponseEntity(new StandedResponse(200,"Success",rentDetail),HttpStatus.OK);
    }




}
