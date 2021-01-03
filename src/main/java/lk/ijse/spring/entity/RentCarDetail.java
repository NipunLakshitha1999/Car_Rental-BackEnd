package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RentCarDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int rentDetailid;
    private double tour;


    @ManyToOne
    @JoinColumn(name = "rentID",referencedColumnName = "rentid")
    private RentCar rentcar;

    @ManyToOne
    @JoinColumn(name = "driverEmail",referencedColumnName = "driverEmail")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "carID",referencedColumnName = "no")
    private Car car;

    public RentCarDetail(double tour, RentCar rentcar, Driver driver, Car car) {
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

    public RentCar getRentcar() {
        return rentcar;
    }

    public void setRentcar(RentCar rentcar) {
        this.rentcar = rentcar;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
