package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {
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
}
