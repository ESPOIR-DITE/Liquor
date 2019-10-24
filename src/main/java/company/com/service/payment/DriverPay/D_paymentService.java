package company.com.service.payment.DriverPay;


import company.com.domain.driverPay.D_pay;
import company.com.repository.payment.D_paymentRepInt;
import company.com.service.payment.D_payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class D_paymentService implements D_payment {
    @Autowired
    D_paymentRepInt d_paymentRepInt;
    private static D_paymentService d_paymentRep;

    private D_paymentService() {
    }
    public static D_paymentService getD_paymentRep(){
        if(d_paymentRep==null){
            d_paymentRep=new D_paymentService();
        }return d_paymentRep;
    }


    @Override
    public D_pay create(D_pay d_pay ) {
        return d_paymentRepInt.save(d_pay);
    }

    @Override
    public D_pay update(D_pay d_pay) {
        return d_paymentRepInt.save(d_pay);
    }

    @Override
    public void delete(String id) {
        d_paymentRepInt.deleteById(id);
    }

    @Override
    public D_pay read(String id) {
        Optional<D_pay> result=d_paymentRepInt.findById(id);

        return result.orElse(null);
    }

    @Override
    public List<D_pay> readAll() {
        return d_paymentRepInt.findAll();
    }
}
