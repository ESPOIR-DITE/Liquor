package company.com.service.item.impl.beverage.beverage_Bridge.impl;
import company.com.domain.item.impl.beverage.beverage_Bridge.Beverage_NonAlcohol;
import company.com.repository.item.impl.beverage.beverage_Bridge.Beverage_NonalcoholRepInt;
import company.com.service.item.impl.beverage.beverage_Bridge.Beverage_NonalcoholInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class Beverage_NonalcoholServ implements Beverage_NonalcoholInt {
    @Autowired
    Beverage_NonalcoholRepInt bn;
    private static Beverage_NonalcoholServ beverage_nonalcoholServ;

    private Beverage_NonalcoholServ() {
    }
    public static Beverage_NonalcoholInt getBeverage_Non(){
        if(beverage_nonalcoholServ==null){
            beverage_nonalcoholServ=new Beverage_NonalcoholServ();
        } return beverage_nonalcoholServ;
    }
    @Override
    public Beverage_NonAlcohol create(Beverage_NonAlcohol beverage_nonAlcohol) {
        return bn.save(beverage_nonAlcohol);
    }
    @Override
    public Beverage_NonAlcohol update(Beverage_NonAlcohol beverage_nonAlcohol) {
        return bn.save(beverage_nonAlcohol);
    }
    @Override
    public void delete(String id) {
        bn.deleteById(id);
    }

    @Override
    public Beverage_NonAlcohol read(String id)
    {
        Optional<Beverage_NonAlcohol> result =bn.findById(id);
        return result.orElse(null);
    }
    @Override
    public List<Beverage_NonAlcohol> readAll() {
        return bn.findAll();
    }
}
