package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addCar")
@CrossOrigin
public class CarController {

    @Autowired
    CarService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCar(@RequestBody CarDTO dto){
        System.out.println(dto );
        service.saveCar(dto);
        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCar(@RequestBody CarDTO dto){
        service.updateCar(dto);

        return new ResponseEntity(new StandedResponse(200,"Success",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCar(@RequestParam String id){
        service.deleteCar(id);

        return new ResponseEntity(new StandedResponse(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/miniCar")
    public ResponseEntity getAllMiniCars(){
        List<CarDTO> allMiniCarsDetail = service.getAllMiniCarsDetail( );
        System.out.println(allMiniCarsDetail);
        return new ResponseEntity(new StandedResponse(200,"Success",allMiniCarsDetail),HttpStatus.OK);
    }
    @GetMapping(path = "/hybrid")
    public ResponseEntity getAllHybridCars(){
        List<CarDTO> allHybridCarsDetail = service.getAllHybridCarsDetail( );
        return new ResponseEntity(new StandedResponse(200,"Success",allHybridCarsDetail),HttpStatus.OK);
    }

    @GetMapping(path = "/priyum")
    public ResponseEntity getAllPrmiumCars(){
        List<CarDTO> allPrmiyumCarsDetail = service.getAllPrmiyumCarsDetail( );
        return new ResponseEntity(new StandedResponse(200,"Success",allPrmiyumCarsDetail),HttpStatus.OK);
    }
    @GetMapping(path = "/luxury")
    public ResponseEntity getAllLuxuryCars(){
        List<CarDTO> allLuxuryCarsDetail = service.getAllLuxuryCarsDetail( );
        return new ResponseEntity(new StandedResponse(200,"Success",allLuxuryCarsDetail),HttpStatus.OK);
    }
    @GetMapping(path = "/miniVan")
    public ResponseEntity getAllMiniVan(){
        List<CarDTO> allMiniVanCarsDetail = service.getAllMiniVanCarsDetail( );
        return new ResponseEntity(new StandedResponse(200,"Success",allMiniVanCarsDetail),HttpStatus.OK);
    }

    @GetMapping(path = "/van")
    public ResponseEntity getAllVan(){
        List<CarDTO> allvanCarsDetail = service.getAllvanCarsDetail( );
        return new ResponseEntity(new StandedResponse(200,"Success",allvanCarsDetail),HttpStatus.OK);
    }

    @GetMapping(params = {"regno"})
    public ResponseEntity getCar(@RequestParam String regno){
        CarDTO car = service.findCar(regno);
        return new ResponseEntity(new StandedResponse(200,"Success",car),HttpStatus.OK);
    }



}
