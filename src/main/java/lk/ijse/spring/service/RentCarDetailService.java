package lk.ijse.spring.service;

import lk.ijse.spring.dto.RentDetailDTO;

import java.util.List;

public interface RentCarDetailService {
    void addRentDetail(RentDetailDTO dto);
    List<RentDetailDTO> getAllDetail();
}
