package company.com.repository.user.userAddress;

import company.com.domain.bridge.User_address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRep extends JpaRepository<User_address,String> {
}
