package company.com.repository.payment.customerPay;

import company.com.domain.customerPayment.CustomerPay;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPayRepInt extends JpaRepository<CustomerPay,String> {
}
