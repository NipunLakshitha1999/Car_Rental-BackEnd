package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RentCar {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int rentid;
    private String carregno;
    private String cardate;
    private String cartime;
    private String cardiver;


    @ManyToOne
    @JoinColumn(name = "customerEmail",referencedColumnName = "email",nullable = false)
    private Customer customer;


    @OneToMany(mappedBy = "rentcar")
    private List<RentCarDetail> details;

    public RentCar(String carregno, String cardate, String cartime, String cardiver, Customer customer) {
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.customer = customer;
    }

    public RentCar(int rentid, String carregno, String cardate, String cartime, String cardiver, Customer customer) {
        this.rentid = rentid;
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.customer = customer;
    }

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public String getCarregno() {
        return carregno;
    }

    public void setCarregno(String carregno) {
        this.carregno = carregno;
    }

    public String getCardate() {
        return cardate;
    }

    public void setCardate(String cardate) {
        this.cardate = cardate;
    }

    public String getCartime() {
        return cartime;
    }

    public void setCartime(String cartime) {
        this.cartime = cartime;
    }

    public String getCardiver() {
        return cardiver;
    }

    public void setCardiver(String cardiver) {
        this.cardiver = cardiver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
