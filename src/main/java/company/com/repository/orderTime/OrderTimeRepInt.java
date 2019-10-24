package company.com.repository.orderTime;


import company.com.domain.orderTiming.OrderTiming;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTimeRepInt extends JpaRepository<OrderTiming,String> {
}
