package company.com.controller.driver;

import company.com.controller.ControllerInt;
import company.com.domain.cashierBuilderPack.Cashier;
import company.com.domain.driver.Driver;
import company.com.domain.genericClasses.G_User;
import company.com.domain.users.Login;
import company.com.domain.users.User;
import company.com.factory.domain.cashierFactory.CashierFactory;
import company.com.factory.domain.driverFactory.DriverFactory;
import company.com.factory.domain.user.LoginFactory;
import company.com.factory.domain.user.UserFactory;
import company.com.service.user.impl.LoginService;
import company.com.service.user.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import company.com.service.Driver.Impl.DriverService;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver")
public class DriverContoller implements ControllerInt<Driver,String> {
    @Autowired
    DriverService driverService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    private Login login;
    private User user;
    private Driver driver;

    @PostMapping("/create")

    public Driver create(@RequestBody G_User g) {

       driver= DriverFactory.getDriver(g.getEmail(),g.getStat(),g.getName(),g.getSurName());
        Driver result=driverService.create(driver);
        if(result!=null) {
            //creating login.
            login = LoginFactory.getLogin(g.getEmail(), g.getPassword());
            loginService.create(login);
            //creating user.
            user= UserFactory.getUser(g.getEmail(),g.getUserType(),"");
            userService.create(user);
            return result;
        }
        return null;

    }

    @Override
    public Driver create(Driver driver) {
        return null;
    }

    @GetMapping("/read")
    @Override
    public Driver read(@RequestParam(value = "id") String id) {
        return driverService.read(id);
    }

    @GetMapping("/delete")
    @Override
    public void delete(@RequestParam(value = "id") String id) {
        driverService.delete(id);
    }

    @PostMapping("/update")
    @Override
    public Driver update(@RequestBody Driver driver) {
        return driverService.update(driver);
    }

    @GetMapping("/reads")
    @Override
    public ArrayList<Driver> readAll() {
        return null;
    }
}
