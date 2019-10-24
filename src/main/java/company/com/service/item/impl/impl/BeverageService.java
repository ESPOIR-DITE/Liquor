package company.com.service.item.impl.impl;


import company.com.domain.item.impl.beverage.Beverage;
import company.com.repository.item.BevergeRepInt;
import company.com.service.item.BevergeInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageService implements BevergeInt {
    @Autowired
    BevergeRepInt beverageRepInt;
    private static BeverageService beverageRep;

    private BeverageService() {
    }
    public static BeverageService getBeverageRep(){
        if(beverageRep==null){
            beverageRep=new BeverageService();
        }return beverageRep;
    }


    @Override
    public Beverage create(Beverage beverage) {
        return beverageRepInt.save(beverage);
    }

    @Override
    public Beverage update(Beverage beverage) {
        return beverageRepInt.save(beverage);
    }

    @Override
    public void delete(String id) {
        beverageRepInt.deleteById(id);
    }

    @Override
    public Beverage read(String id) {
        Optional<Beverage> result=beverageRepInt.findById(id);
        return result.orElse(null);
    }
    public Beverage getBev(String name){
        List<Beverage> result=beverageRepInt.findAll();
        for(Beverage beverage:result){
            if(beverage.getBevName().equals(name)){
                return beverage;
            }
        }
        return null;
    }

    @Override
    public List<Beverage> readAll() {
        return beverageRepInt.findAll();
    }
}
