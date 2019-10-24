package company.com.service.payment.customerPay.impl;

import company.com.domain.customerPayment.impl.Cash;
import company.com.repository.payment.customerPay.CashRepInt;
import company.com.service.payment.customerPay.CashInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CashService implements CashInt {

    @Autowired
    CashRepInt cashRepInt;
    private static CashService cashRep;

    private CashService() {}


    public static CashService getCashRepService(){
        if (cashRep == null) {
            cashRep = new CashService();
        }
        return cashRep;
    }


    @Override
    public Cash create(Cash cash) {
        return cashRepInt.save(cash);
    }

    @Override
    public Cash update(Cash cash) {
        return cashRepInt.save(cash);
    }

    @Override
    public void delete(String id) {
        cashRepInt.deleteById(id);
    }

    @Override
    public Cash read(String id) {
        Optional<Cash> result=cashRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Cash> readAll() {
        return cashRepInt.findAll();
    }
}
