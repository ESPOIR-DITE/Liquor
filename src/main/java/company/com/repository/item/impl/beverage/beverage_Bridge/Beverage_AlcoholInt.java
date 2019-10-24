package company.com.repository.item.impl.beverage.beverage_Bridge;

import company.com.domain.item.impl.beverage.beverage_Bridge.Beverage_Alcohol;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Beverage_AlcoholInt extends JpaRepository<Beverage_Alcohol,String> {
}
