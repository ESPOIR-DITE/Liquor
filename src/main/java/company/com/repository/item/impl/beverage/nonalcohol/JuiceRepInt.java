package company.com.repository.item.impl.beverage.nonalcohol;

import company.com.domain.item.impl.beverage.nonalcohol.impl.Juice;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuiceRepInt extends JpaRepository<Juice,String> {
}
