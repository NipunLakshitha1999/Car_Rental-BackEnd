package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car implements Serializable {

    @Id
    private String no;
    private String carBrand;
    private String carType;
    private int carPassengers;
    private String carTransmission;
    private String carFuel;
    private String carColor;
    private double carCount;
    private double carFreeMilageFDay;
    private double carFreeMilageFMonth;
    private double carPriceFRentDaily;
    private double carPricesFRentMonthly;
    private double carPriceFExKM;


    @OneToMany(mappedBy = "car")
    private List<RentCarDetail> details;
}
