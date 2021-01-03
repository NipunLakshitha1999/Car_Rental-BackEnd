package lk.ijse.spring.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RentCarPassDetailDTO {
    private int rentid;
    private String carregno;
    private String cardate;
    private String cartime;
    private String cardiver;
    private String cusemail;

    public RentCarPassDetailDTO(int rentid, String carregno, String cardate, String cartime, String cardiver, String cusemail) {
        this.rentid = rentid;
        this.carregno = carregno;
        this.cardate = cardate;
        this.cartime = cartime;
        this.cardiver = cardiver;
        this.cusemail = cusemail;
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

    public String getCusemail() {
        return cusemail;
    }

    public void setCusemail(String cusemail) {
        this.cusemail = cusemail;
    }
}
