package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.service.PaymentService;
import org.hibernate.annotations.Parent;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    PaymentRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public void addPayment(PaymentDTO dto) {
        if(!repo.existsById(dto.getId())){
            Payment map = mapper.map(dto, Payment.class);
            repo.save(map);

        }else {
            throw new RuntimeException("Invalid");
        }

    }

    @Override
    public List<PaymentDTO> getPayment() {
        List<Payment> all = repo.findAll( );
        return mapper.map(all,new TypeToken<List<PaymentDTO>>(){}.getType());
    }
}
