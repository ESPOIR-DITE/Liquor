package company.com.service.item.impl.beverage.alcohol.impl;
import company.com.domain.item.impl.beverage.alcohol.impl.Vine;
import company.com.repository.item.impl.beverage.alcohol.VineRepInt;
import company.com.service.item.impl.beverage.alcohol.VineInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VineService implements VineInt {
    @Autowired
    private VineRepInt vineRepInt;
    private static VineService vine=null;


    private VineService() {
    }
    public static VineService getVine(){
        if(vine==null){
            vine = new VineService();
        }return vine;
    }


    @Override
    public Vine create(Vine vine) {
        return vineRepInt.save(vine);
    }

    @Override
    public Vine update(Vine vine) {
        return vineRepInt.save(vine);
    }

    @Override
    public void delete(String id) {
        vineRepInt.deleteById(id);
    }

    @Override
    public Vine read(String id) {
        Optional<Vine> result=vineRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Vine> readAll() {
        return vineRepInt.findAll();
    }
    public Vine buyItem(String itemName){
        List<Vine> result=vineRepInt.findAll();
        for(Vine vine: result){
            if(vine.getName().equals(itemName)){
                return vine;
            }
        }
        return null;
    }
}
