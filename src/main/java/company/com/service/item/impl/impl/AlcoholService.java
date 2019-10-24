package company.com.service.item.impl.impl;

import company.com.domain.item.impl.beverage.alcohol.Alcohol;
import company.com.repository.item.AlcoholRepInt;
import company.com.service.item.AlcoholInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlcoholService implements AlcoholInt {
    @Autowired
    private AlcoholRepInt alcoholRepInt;
    private static AlcoholService alcoholRep=null;

    private AlcoholService() {
    }
    public static AlcoholService getAlcoholRep(){
        if(alcoholRep==null){
            alcoholRep=new AlcoholService();
        }return alcoholRep;
    }
    @Override
    public Alcohol create(Alcohol alcohol) {
        return alcoholRepInt.save(alcohol);
    }

    @Override
    public Alcohol update(Alcohol alcohol) {
        return alcoholRepInt.save(alcohol);
    }

    @Override
    public void delete(String id) {
        alcoholRepInt.deleteById(id);
    }

    @Override
    public Alcohol read(String id) {
        Optional<Alcohol> result=alcoholRepInt.findById(id);
        return result.orElse(null);
    }
    @Override
    public List<Alcohol> readAll() {
        return alcoholRepInt.findAll();
    }
}
