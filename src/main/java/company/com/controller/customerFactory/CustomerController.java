package company.com.controller.customerFactory;

import company.com.domain.bridge.User_address;
import company.com.domain.customerBuilder.Customer;
import company.com.domain.genericClasses.G_User;
import company.com.domain.users.Address;
import company.com.domain.users.Login;
import company.com.factory.domain.address.AddressFactory;
import company.com.factory.domain.bridge.User_AddressFactory;
import company.com.factory.domain.customerFactory.CustomerFactory;
import company.com.factory.domain.user.LoginFactory;
import company.com.service.user.impl.LoginService;
import company.com.service.user.userAddress.impl.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import company.com.service.address.Impl.AddressService;
import company.com.service.customerServ.impl.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("LDS/customer")
public class CustomerController  {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserAddressService userAddressService;


    @PostMapping("/create")
    public Customer create(@RequestBody G_User ca) {
        Customer customer=CustomerFactory.getCustomer(ca.getEmail(),ca.getName(),ca.getSurName(),ca.getDescription());
        Customer resulta=customerService.create(customer);
        String addressId=null;
        if(resulta!=null){

            //creating Addess
            if(!ca.getAddress().equals(null)&&!ca.getPhoner_Number().equals(null)){
            Address ad= AddressFactory.getAddress(ca.getAddress(),ca.getPhoner_Number());
            addressId=addressService.create(ad).getAddressId();
            }

            //creating User_Addess bridge table
            if(!addressId.equals(null)){
            User_address user_address= User_AddressFactory.getCustomerAddress(ca.getEmail(),addressId,ca.getDescription());
            userAddressService.create(user_address);
            }

            //creating loging
            if(!ca.getEmail().equals(null)||!ca.getPassword().equals(null)){
            Login login= LoginFactory.getLogin(ca.getEmail(),ca.getPassword());
            loginService.create(login);
            }

            return customer;
        }
        return null;
    }

    @GetMapping("/read")
    public Customer read(@RequestParam(value = "id") String id) {
        return customerService.read(id);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam(value = "id") String id) {
        addressService.read(id);
        customerService.delete(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        Customer cust=customerService.update(customer);
        return cust;
    }

    @GetMapping("/reads")
    public List<Customer> readAll() {
        return customerService.readAll();
    }
    /** @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    @Override
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping("/read")
    @Override
    public Customer read(@RequestParam(value = "id") String id) {
        return customerService.read(id);
    }

    @GetMapping("/delete")
    @Override
    public void delete(@RequestParam(value = "id") String id) {
        customerService.delete(id);
    }

    @PostMapping("/update")
    @Override
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @GetMapping("/reads")
    @Override
    public ArrayList<Customer> readAll() {
        return customerService.readAlll();
    }*/
}
