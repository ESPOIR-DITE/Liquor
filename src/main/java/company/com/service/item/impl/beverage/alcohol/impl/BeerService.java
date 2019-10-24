package company.com.service.item.impl.beverage.alcohol.impl;

import company.com.domain.item.impl.beverage.alcohol.impl.Beer;
import company.com.repository.item.impl.beverage.alcohol.BeerRepInt;
import company.com.service.item.impl.beverage.alcohol.BeerInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService implements BeerInt {
    @Autowired
    BeerRepInt beerRepInt;

    private static BeerService beerService=null;
    //private BeerRep beerRep= BeerRepFactory.getBeerRep();
    private BeerService() { }
    public static BeerService getBeerRep(){
        if(beerService==null){
            beerService=new BeerService();
        }return beerService;
    }


    @Override
    public Beer create(Beer beer) {
        return beerRepInt.save(beer);
    }

    @Override
    public Beer update(Beer beer) {
        return beerRepInt.save(beer);
    }

    @Override
    public void delete(String id) {
    Optional<Beer> result=beerRepInt.findById(id);
        beerRepInt.deleteById(id);
    }

    @Override
    public Beer read(String id) {
        Optional<Beer> result=beerRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Beer> readAll() {
        return beerRepInt.findAll();
    }
    public Beer selItem(String name,String size){
        List<Beer>result=beerRepInt.findAll();
        for(Beer beer:result){
            if(beer.getName().equals(name)&&beer.getSize().equals(size))
                return beer;
        }
        return null;
    }
}
