package company.com.service.payment.customerPay.impl;

import company.com.domain.customerPayment.CustomerPay;
import company.com.repository.payment.customerPay.CustomerPayRepInt;
import company.com.service.payment.customerPay.CustomerPayInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerPayService implements CustomerPayInt {
    @Autowired
    CustomerPayRepInt customerPayRepInt;
    private static CustomerPayService customerPayService;

    private CustomerPayService() {
    }
    public static CustomerPayService getCustomerPayService(){
        if(customerPayService==null){
            customerPayService=new CustomerPayService();
        }return customerPayService;
    }

    @Override
    public CustomerPay create(CustomerPay customerPay) {
        return customerPayRepInt.save(customerPay);
    }

    @Override
    public CustomerPay update(CustomerPay customerPay) {
        return customerPayRepInt.save(customerPay);
    }

    @Override
    public void delete(String id) {
        customerPayRepInt.deleteById(id);
    }

    @Override
    public CustomerPay read(String id) {
        Optional<CustomerPay> result=customerPayRepInt.findById(id);
        return result.orElse(null);
    }
    public CustomerPay findOrder(String orderNumber){
        List<CustomerPay>result=customerPayRepInt.findAll();
        for(CustomerPay customerPay: result){
            if(customerPay.getOrderNumber().equals(orderNumber)){
                return customerPay;
            }
        }
        return null;
    }

    @Override
    public List<CustomerPay> readAll() {
        return customerPayRepInt.findAll();
    }
}
