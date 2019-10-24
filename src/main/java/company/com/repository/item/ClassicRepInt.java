package company.com.repository.item;

import company.com.domain.item.impl.classic.Classic;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassicRepInt extends JpaRepository<Classic,String> {
}
