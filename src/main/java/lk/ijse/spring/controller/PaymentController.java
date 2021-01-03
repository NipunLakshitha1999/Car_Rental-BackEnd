package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addPayment(@RequestBody PaymentDTO dto){
        service.addPayment(dto);

        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getPaymentdetail(){
        List<PaymentDTO> payment = service.getPayment( );
        return new ResponseEntity(new StandedResponse(200,"Success",payment),HttpStatus.OK);
    }
}
