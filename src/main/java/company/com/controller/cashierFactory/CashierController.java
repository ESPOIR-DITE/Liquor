package company.com.controller.cashierFactory;
import company.com.controller.ControllerInt;
import company.com.domain.bridge.User_address;
import company.com.domain.cashierBuilderPack.Cashier;
import company.com.domain.genericClasses.G_User;
import company.com.domain.users.Address;
import company.com.domain.users.Login;
import company.com.domain.users.User;
import company.com.factory.domain.address.AddressFactory;
import company.com.factory.domain.bridge.User_AddressFactory;
import company.com.factory.domain.cashierFactory.CashierFactory;
import company.com.factory.domain.user.LoginFactory;
import company.com.factory.domain.user.UserFactory;
import company.com.service.Driver.Impl.DriverService;
import company.com.service.address.Impl.AddressService;
import company.com.service.customerServ.impl.CustomerService;
import company.com.service.user.impl.LoginService;
import company.com.service.user.impl.UserService;
import company.com.service.user.userAddress.impl.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import company.com.service.Cashier.impl.CashierServicer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("LDS/cashier")
public class CashierController {
    @Autowired
    private CashierServicer cashierServicer;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserAddressService userAddressService;

    private Cashier cashier1;
    private Login login;
    private User user;
    private User_address user_address;
    private Address address;

    private String addressId=null;

    @PostMapping("/create")
    public Cashier create(@RequestBody G_User g) {
        cashier1= CashierFactory.getCashier(g.getEmail(),g.getName(),g.getSurName());
        Cashier result=cashierServicer.create(cashier1);
        if(result!=null) {
            //creating login.
            if(g.getEmail()!=null&&g.getPassword()!=null) {
                login = LoginFactory.getLogin(g.getEmail(), g.getPassword());
                loginService.create(login);
            }
            //creating user.
           // user= UserFactory.getUser(g.getEmail(),g.getUserType(),"");
           // userService.create(user);

            // create Address
            if(g.getAddress().equals(null)&&g.getPhoner_Number().equals(null)){
            address= AddressFactory.getAddress(g.getAddress(),g.getPhoner_Number());
            addressId=addressService.create(address).getAddressId();
            }

            //creating UserAddress
            if(addressId.equals(null)){
            user_address= User_AddressFactory.getCustomerAddress(g.getEmail(),addressId,g.getDescription());
            userAddressService.create(user_address);
            return result;
            }
        }
        return null;
    }
    @GetMapping("/read")
    public Cashier read(@RequestParam(value = "id")String id) {
        return cashierServicer.read(id);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam(value = "id") String id) {
        cashierServicer.delete(id);
    }

    @PostMapping("/update")
    public Cashier update(@RequestBody Cashier cashier) {
        return cashierServicer.update(cashier);
    }

    @GetMapping("/reads")
    public List<Cashier> readAll() {
        return cashierServicer.readAll();
    }
}
