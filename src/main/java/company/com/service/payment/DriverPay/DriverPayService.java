package company.com.service.payment.DriverPay;


import company.com.domain.driverPay.DriverPay;
import company.com.repository.payment.DriverPayRepInt;
import company.com.service.payment.DriverPayInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverPayService implements DriverPayInt {

    @Autowired
    DriverPayRepInt driverPayRepInt;
    private static DriverPayService driverPayRep=null;

    private DriverPayService() {

    }

    public static DriverPayService getDriverPayRep() {

        if (driverPayRep==null)
        {
             driverPayRep=new DriverPayService();
        }return driverPayRep;
    }


    @Override
    public DriverPay create(DriverPay driverPay) {
        return driverPayRepInt.save(driverPay);
    }

    @Override
    public DriverPay update(DriverPay driverPay) {
        return driverPayRepInt.save(driverPay);
    }

    @Override
    public void delete(String id) {
        driverPayRepInt.deleteById(id);
    }

    @Override
    public DriverPay read(String id){
        Optional<DriverPay> result=driverPayRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<DriverPay> readAll() {
        return driverPayRepInt.findAll();
    }
}
