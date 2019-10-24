package company.com.service.user.userAddress.impl;

import company.com.domain.bridge.User_address;
import company.com.repository.user.userAddress.UserAddressRep;
import company.com.service.user.userAddress.UserAddressServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService implements UserAddressServiceInt {
    private static UserAddressService userAddressService;
    @Autowired
    UserAddressRep userAddressRep;

    private UserAddressService() {
    }
    public static UserAddressService getUserAddressService(){
        if(userAddressService==null){
            userAddressService=new UserAddressService();
        }return userAddressService;
    }

    @Override
    public User_address create(User_address user_address) {
        return userAddressRep.save(user_address);
    }

    @Override
    public User_address update(User_address user_address) {
        return userAddressRep.save(user_address);
    }

    @Override
    public void delete(String id) {
        Optional<User_address> result=userAddressRep.findById(id);
        userAddressRep.deleteById(id);
        result.orElse(null);
    }

    @Override
    public User_address read(String id) {
        Optional<User_address> result=userAddressRep.findById(id);
       return result.orElse(null);
    }

    @Override
    public List<User_address> readAll() {
        return userAddressRep.findAll();
    }
}
