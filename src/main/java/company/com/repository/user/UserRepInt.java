package company.com.repository.user;

import company.com.domain.users.User;
import company.com.repository.Irepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepInt extends JpaRepository<User,String> {
}
