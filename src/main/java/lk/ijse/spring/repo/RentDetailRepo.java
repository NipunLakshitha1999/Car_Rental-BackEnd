package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RentCarDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDetailRepo extends JpaRepository<RentCarDetail, Integer> {
}
