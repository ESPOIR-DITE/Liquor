package company.com.service.item.impl.impl;

import company.com.domain.item.impl.beverage.nonalcohol.NonAlcohol;
import company.com.repository.item.NonAlcoholRepInt;
import company.com.service.item.NonAlcoholServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NonAlcholService implements NonAlcoholServiceInt {
    @Autowired
    NonAlcoholRepInt nonAlcoholRepInt;
    private static NonAlcholService nonAlcholRep;
    private NonAlcholService(){

    }
    public static NonAlcholService getNonAlcholRep(){
        if(nonAlcholRep==null){
            nonAlcholRep=new NonAlcholService();
        }return nonAlcholRep;
    }

    @Override
    public NonAlcohol create(NonAlcohol nonAlcohol) {
        return nonAlcoholRepInt.save(nonAlcohol);
    }

    @Override
    public NonAlcohol update(NonAlcohol nonAlcohol) {
        return nonAlcoholRepInt.save(nonAlcohol);
    }

    @Override
    public void delete(String id) {
        nonAlcoholRepInt.deleteById(id);
    }

    @Override
    public NonAlcohol read(String id) {
        Optional<NonAlcohol>result=nonAlcoholRepInt.findById(id);
        return result.orElse(null);
    }
    @Override
    public List<NonAlcohol> readAll() {
        return nonAlcoholRepInt.findAll();
    }
//    public NonAlcohol buyItem(String name){
//        List<NonAlcohol>result=nonAlcoholRepInt.findAll();
//        for(NonAlcohol nonAlcohol:result){
//            if(nonAlcohol.)
//        }
//    }
}
