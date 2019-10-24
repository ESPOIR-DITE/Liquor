package company.com.repository.payment;


import company.com.domain.driverPay.D_pay;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface D_paymentRepInt extends JpaRepository<D_pay,String> {
}
