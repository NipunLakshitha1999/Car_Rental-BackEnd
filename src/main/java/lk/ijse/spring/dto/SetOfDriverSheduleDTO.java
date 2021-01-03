package lk.ijse.spring.dto;

public class SetOfDriverSheduleDTO {
    private String rentDetailid;
    private double tour;
    private String carregno;
    private String driverid;
    private int rentid;
    private String cardate;
    private String cartime;

    public SetOfDriverSheduleDTO() {
    }

    public SetOfDriverSheduleDTO(String rentDetailid, double tour, String carregno, String driverid, int rentid, String cardate, String cartime) {
        this.rentDetailid = rentDetailid;
        this.tour = tour;
        this.carregno = carregno;
        this.driverid = driverid;
        this.rentid = rentid;
        this.cardate = cardate;
        this.cartime = cartime;
    }

    public String getRentDetailid() {
        return rentDetailid;
    }

    public void setRentDetailid(String rentDetailid) {
        this.rentDetailid = rentDetailid;
    }

    public double getTour() {
        return tour;
    }

    public void setTour(double tour) {
        this.tour = tour;
    }

    public String getCarregno() {
        return carregno;
    }

    public void setCarregno(String carregno) {
        this.carregno = carregno;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
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
}
