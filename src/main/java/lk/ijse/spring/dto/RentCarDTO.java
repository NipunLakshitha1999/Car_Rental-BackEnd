package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentCarDTO {
    private int rentid;
    private String carregno;
    private String cardate;
    private String cartime;
    private String cardiver;
    private String cusemail;
    private CustomerDTO customer;

    public RentCarDTO(String carregno, String cardate, String cartime, String cardiver, String cusemail) {
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.cusemail = cusemail;
    }

    public RentCarDTO(String carregno, String cardate, String cartime, String cardiver, CustomerDTO customer) {
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.customer = customer;
    }

    public RentCarDTO(int rentid, String carregno, String cardate, String cartime, String cardiver,  CustomerDTO customer) {
        this.rentid = rentid;
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.customer = customer;
    }

    public RentCarDTO(int rentid, String carregno, String cardate, String cartime, String cardiver, String cusemail) {
        this.rentid = rentid;
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.cusemail = cusemail;
    }
}
