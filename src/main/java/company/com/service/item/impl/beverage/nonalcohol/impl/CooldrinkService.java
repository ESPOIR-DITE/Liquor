package company.com.service.item.impl.beverage.nonalcohol.impl;


import company.com.domain.item.impl.beverage.nonalcohol.impl.CoolDrink;
import company.com.repository.item.impl.beverage.nonalcohol.CooldrinkRepInt;
import company.com.service.item.impl.beverage.nonalcohol.CooledrinkInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CooldrinkService implements CooledrinkInt {
    private static CooldrinkService cooledrinkRep = null;
    @Autowired
    CooldrinkRepInt cooldrinkRepInt;

    private CooldrinkService() {
    }

    public static CooldrinkService getCooledrinkRep() {
        if (cooledrinkRep == null) {
            cooledrinkRep = new CooldrinkService();
        }
        return cooledrinkRep;
    }

    @Override
    public CoolDrink create(CoolDrink coolDrink) {
        return cooldrinkRepInt.save(coolDrink);
    }

    @Override
    public CoolDrink update(CoolDrink coolDrink) {
        return cooldrinkRepInt.save(coolDrink);
    }

    @Override
    public void delete(String id) {
        cooldrinkRepInt.deleteById(id);
    }

    @Override
    public CoolDrink read(String id) {
        Optional<CoolDrink> result = cooldrinkRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<CoolDrink> readAll() {
        return cooldrinkRepInt.findAll();
    }

    public CoolDrink buyItem(String itemName) {
        List<CoolDrink> result = cooldrinkRepInt.findAll();
        for (CoolDrink coolDrink : result) {
            if (coolDrink.getName().equals(itemName)) {
                return coolDrink;
            }
        }
        return null;
    }
}
