package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer{


    @Id
    private String email;
    private String nic;
    private String lisenNo;
    private String name;
    private String address;
    private int contact;
    private String password;


    public Customer() {
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer(String email, String nic, String lisenNo, String name, String address, int contact, String password) {
        this.email = email;
        this.nic = nic;
        this.lisenNo = lisenNo;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
    }

    public Customer(String email, String nic, String lisenNo, String name, String address, int contact, String password, List<RentCar> rent) {
        this.email = email;
        this.nic = nic;
        this.lisenNo = lisenNo;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
        this.rent = rent;
    }

    @OneToMany(mappedBy = "customer")
    private List<RentCar> rent=new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getLisenNo() {
        return lisenNo;
    }

    public void setLisenNo(String lisenNo) {
        this.lisenNo = lisenNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
