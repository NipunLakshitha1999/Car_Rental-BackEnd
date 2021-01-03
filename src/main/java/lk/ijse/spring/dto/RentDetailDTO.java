package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.RentCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
public class RentDetailDTO {
    private int rentDetailid;
    private double tour;
    private int rentid;
    private String driverid;
    private RentCarDTO rentcar;
    private DriverDTO driver;
    private CarDTO car;

    public RentDetailDTO(double tour, int rentid, String driverid) {
        this.tour = tour;
        this.rentid = rentid;
        this.driverid = driverid;
    }

    public RentDetailDTO(double tour, RentCarDTO rentcar, DriverDTO driver, CarDTO car) {
        this.tour = tour;
        this.rentcar = rentcar;
        this.driver = driver;
        this.car = car;
    }

    public RentDetailDTO(int rentDetailid, RentCarDTO rentcar, DriverDTO driver, CarDTO car) {
        this.rentDetailid = rentDetailid;
        this.rentcar = rentcar;
        this.driver = driver;
        this.car = car;
    }

    public RentDetailDTO(int rentDetailid, double tour, int rentid, String driverid, RentCarDTO rentcar, DriverDTO driver, CarDTO car) {
        this.rentDetailid = rentDetailid;
        this.tour = tour;
        this.rentcar = rentcar;
        this.driver = driver;
        this.car = car;
    }

    public int getRentDetailid() {
        return rentDetailid;
    }

    public void setRentDetailid(int rentDetailid) {
        this.rentDetailid = rentDetailid;
    }

    public double getTour() {
        return tour;
    }

    public void setTour(double tour) {
        this.tour = tour;
    }

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public RentCarDTO getRentcar() {
        return rentcar;
    }

    public void setRentcar(RentCarDTO rentcar) {
        this.rentcar = rentcar;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "RentDetailDTO{" +
                "rentDetailid=" + rentDetailid +
                ", tour=" + tour +
                ", rentid=" + rentid +
                ", driverid='" + driverid + '\'' +
                ", rentcar=" + rentcar +
                ", driver=" + driver +
                ", car=" + car +
                '}';
    }
}
