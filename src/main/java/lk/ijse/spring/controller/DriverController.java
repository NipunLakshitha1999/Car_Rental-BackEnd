package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.SetOfDriverSheduleDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService service;

//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity saveDriver(@RequestBody DriverDTO dto){
//
//        BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder( );
//        String encode = PasswordEncoder.encode(dto.getDriverCode( ));
//        DriverDTO driver=new DriverDTO(dto.getDriverEmail(),encode);
//        service.saveDriver(driver);
//
//        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
//    }
        @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity LoginDriver(@RequestBody DriverDTO dto){

        BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder( );
            DriverDTO driverDTO = service.LoginDriver(dto);
            boolean matches = PasswordEncoder.matches(dto.getDriverCode( ), driverDTO.getDriverCode( ));

            if (matches){
                return new ResponseEntity(new StandedResponse(200,"Success",null),HttpStatus.OK);
            }else {
                return new ResponseEntity(new StandedResponse(500,"Fail",null),HttpStatus.EXPECTATION_FAILED);
            }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path = "/saveDriver")
   public ResponseEntity saveDriver(@RequestBody DriverDTO dto){
        BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder( );
        String driverCode = dto.getDriverCode( );
        String encode = PasswordEncoder.encode(driverCode);

        DriverDTO dto1=new DriverDTO(dto.getDriverEmail(),encode,dto.getDriverName(),dto.getDiverAddress(),dto.getDiverContact(),dto.getStatus());
        service.SaveDriver(dto1);
        return new ResponseEntity(new StandedResponse(200,"Succes",null),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriverDetail(){
        List<DriverDTO> allDrivers = service.getAllDrivers( );
        System.out.println(allDrivers);
        return new ResponseEntity(new StandedResponse(200,"Success",allDrivers),HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path = "/UpdateDriver")
    public ResponseEntity UpdateDriver(@RequestBody DriverDTO dto){
        DriverDTO driver = service.findDriver(dto.getDriverEmail( ));
        DriverDTO dto1=new DriverDTO(dto.getDriverEmail(),driver.getDriverCode(),dto.getDriverName(),driver.getDiverAddress(),driver.getDiverContact(),dto.getStatus());
        service.updateDiverStatus(dto1);

        return new ResponseEntity(new StandedResponse(200,"Success",null),HttpStatus.OK);
    }
    @GetMapping(path = "/shedule")
    public ResponseEntity getDriverShedule(@RequestParam String email){
        System.out.println("getDriver called"+email);
        List<Object> allSheduleByID = service.getAllSheduleByID(email);
        System.out.println(allSheduleByID);
        return new ResponseEntity(new StandedResponse(200,"Success",allSheduleByID),HttpStatus.OK);
    }

}
