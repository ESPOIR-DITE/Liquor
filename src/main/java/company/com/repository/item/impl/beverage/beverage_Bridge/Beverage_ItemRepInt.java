package company.com.repository.item.impl.beverage.beverage_Bridge;

import company.com.domain.item.impl.ItemBridge.Item_beverage;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Beverage_ItemRepInt extends JpaRepository<Item_beverage,String> {
}
