package company.com.repository.payment.customerPay;

import company.com.domain.customerPayment.impl.Cash;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepInt extends JpaRepository<Cash, String> {
}
