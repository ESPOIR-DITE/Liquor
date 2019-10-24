package company.com.repository.item;

import company.com.domain.item.Item;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepInt extends JpaRepository<Item,String> {

}
