package lk.ijse.spring.repo;

import lk.ijse.spring.entity.CustomerSignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerSignInRepo extends JpaRepository<CustomerSignIn,String> {

}
