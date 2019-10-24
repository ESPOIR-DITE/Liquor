package company.com.repository.payment.customerPay;

import company.com.domain.customerPayment.impl.Card;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepInt extends JpaRepository<Card,String> {
}
