package company.com.repository.item.impl.beverage.alcohol;

import company.com.domain.item.impl.beverage.alcohol.impl.Whisky;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepInt extends JpaRepository<Whisky,String> {
}
