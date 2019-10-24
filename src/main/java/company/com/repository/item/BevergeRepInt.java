package company.com.repository.item;

import company.com.domain.item.impl.beverage.Beverage;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BevergeRepInt extends JpaRepository<Beverage,String> {
}
