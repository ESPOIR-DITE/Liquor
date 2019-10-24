package company.com.repository.item.impl.classic;
import company.com.domain.item.impl.classic.impl.Snakes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnakesRepInt extends JpaRepository<Snakes,String> {
}
