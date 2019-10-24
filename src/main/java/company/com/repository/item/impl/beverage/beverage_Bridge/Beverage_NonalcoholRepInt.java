package company.com.repository.item.impl.beverage.beverage_Bridge;

import company.com.domain.item.impl.beverage.beverage_Bridge.Beverage_NonAlcohol;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Beverage_NonalcoholRepInt extends JpaRepository<Beverage_NonAlcohol,String> {
}
