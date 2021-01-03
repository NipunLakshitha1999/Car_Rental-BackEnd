package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class rentDetailDataPassDTO {
    private int rentDetailID;
    private double KM;
    private int rent;
    private String car;
    private String driver;

    public rentDetailDataPassDTO() {
    }

    public rentDetailDataPassDTO(int rentDetailID, double KM, int rent, String car, String driver) {
        this.rentDetailID = rentDetailID;
        this.KM = KM;
        this.rent = rent;
        this.car = car;
        this.driver = driver;
    }

    public int getRentDetailID() {
        return rentDetailID;
    }

    public void setRentDetailID(int rentDetailID) {
        this.rentDetailID = rentDetailID;
    }

    public double getKM() {
        return KM;
    }

    public void setKM(double KM) {
        this.KM = KM;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "rentDetailDataPassDTO{" +
                "rentDetailID=" + rentDetailID +
                ", KM=" + KM +
                ", rent=" + rent +
                ", car='" + car + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
