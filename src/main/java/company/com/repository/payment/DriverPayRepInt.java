package company.com.repository.payment;


import company.com.domain.driverPay.DriverPay;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverPayRepInt extends JpaRepository<DriverPay, String> {
}
