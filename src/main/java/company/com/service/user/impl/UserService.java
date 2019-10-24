package company.com.service.user.impl;


import company.com.domain.users.User;
import company.com.repository.user.UserRepInt;
import company.com.service.user.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInt {
    @Autowired
    UserRepInt userRep;
    private static UserService userService;
    //private UserRep userRep=UserRepFactory.getUserRep();

    private UserService() {
    }
    public static UserService getUserService(){
        if(userService==null){
            userService=new UserService();
        }return userService;
    }

    @Override
    public User create(User user) {
        return userRep.save(user);
    }

    @Override
    public User update(User user) {
        return userRep.save(user);
    }

    @Override
    public void delete(String id) {
        userRep.deleteById(id);
    }

    @Override
    public User read(String id) {
        Optional<User>result=userRep.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<User> readAll() {
        return userRep.findAll();
    }
}
