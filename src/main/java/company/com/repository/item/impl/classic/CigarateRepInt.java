package company.com.repository.item.impl.classic;

import company.com.domain.item.impl.classic.impl.Cigarate;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CigarateRepInt extends JpaRepository<Cigarate,String> {
}
