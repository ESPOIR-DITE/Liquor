package company.com.service.item.impl.beverage.alcohol.impl;

import company.com.domain.item.impl.beverage.alcohol.impl.Whisky;
import company.com.repository.item.impl.beverage.alcohol.WhiskyRepInt;
import company.com.repository.item.impl.beverage.alcohol.impl.WhiskyRep;
import company.com.service.item.impl.beverage.alcohol.WhiskyInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WhiskyService implements WhiskyInt {
    private static WhiskyService whiskyRep = null;
    @Autowired
    private WhiskyRepInt whiskyRepInt;

    private WhiskyService() {
    }

    public static WhiskyService getWhiskyRep() {
        if (whiskyRep == null) {
            whiskyRep = new WhiskyService();
        }
        return whiskyRep;
    }


    @Override
    public Whisky create(Whisky whisky) {
        return this.whiskyRepInt.save(whisky);
    }

    @Override
    public Whisky update(Whisky whisky) {
        return this.whiskyRepInt.save(whisky);
    }

    @Override
    public void delete(String id) {
        whiskyRepInt.deleteById(id);
    }

    @Override
    public Whisky read(String id) {
        Optional<Whisky> result=whiskyRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Whisky> readAll() {
        return whiskyRepInt.findAll();
    }
    public Whisky buyItem(String name){
        List<Whisky>result=whiskyRepInt.findAll();
        for(Whisky whisky: result){
            if(whisky.getName().equals(name)){
                return whisky;
            }
        }return null;
    }
}
