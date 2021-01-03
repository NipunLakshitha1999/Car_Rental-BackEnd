package lk.ijse.spring.controller;

import lk.ijse.spring.dto.*;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.RentCarDetailService;
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
@RequestMapping("/api/v1/RentDetail")
@CrossOrigin
public class RentDetailController {

    @Autowired
    RentCarDetailService service;

    @Autowired
    CarService carService;

    @Autowired
    RentCarService rentCarService;

    @Autowired
    DriverService driverService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path = "/inputDetail")
    public ResponseEntity addRentDetail(@RequestBody RentDetailDTO dto){
        System.out.println("Request dto"+dto);
        //------------------------------//

        DriverDTO driver = findDriver(dto.getDriverid());

        RentCarDTO rent = findRent(dto.getRentid());

        //------------------------------//

        CarDTO carDetails = getCarDetails(rent.getCarregno( ));

        //----------------------------//



        System.out.println("car detail"+carDetails);

        RentDetailDTO dto1=new RentDetailDTO(dto.getTour(),rent,driver,carDetails);
        System.out.println(dto1);
        service.addRentDetail(dto1);

        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }

    public CarDTO getCarDetails(String regNo){
        System.out.println("car detail called");
        CarDTO carDetail = carService.getCarDetail(regNo);
        return carDetail;
    }

    public RentCarDTO findRent(int id){
        System.out.println("rentCalled");
        RentCarDTO rentRecode = rentCarService.findRentRecode(id);
        System.out.println("rent recode"+rentRecode);

        return rentRecode;
    }

    public DriverDTO findDriver(String dEmail){
        System.out.println("driver caleed");
        DriverDTO driver = driverService.findDriver(dEmail);
        System.out.println("driver detail"+driver);

        return driver;
    }

    @GetMapping
    public ResponseEntity getAllRentDetailFromRentDetail(){
        List<RentDetailDTO> allDetail = service.getAllDetail( );
        System.out.println(allDetail );
        List<rentDetailDataPassDTO> passdetail=new ArrayList<>();
        for (RentDetailDTO d:allDetail) {
            passdetail.add(new rentDetailDataPassDTO(d.getRentDetailid(),d.getTour(),d.getRentcar().getRentid(),d.getRentcar().getCarregno(),d.getDriver().getDriverEmail()));
        }
        System.out.println(passdetail);
        return new ResponseEntity(new StandedResponse(200,"Success",passdetail),HttpStatus.OK);
    }
}
