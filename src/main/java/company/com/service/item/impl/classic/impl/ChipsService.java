package company.com.service.item.impl.classic.impl;


import company.com.domain.item.impl.classic.impl.Chips;
import company.com.repository.item.impl.classic.ChipsRepInt;
import company.com.service.item.impl.classic.ChipsInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChipsService implements ChipsInt {
    @Autowired
    private ChipsRepInt chipsRepInt;
    private static ChipsService chipsRepl;
    private ChipsService() {
    }
    public static ChipsService getChipsRepl(){
        if(chipsRepl==null){
            chipsRepl=new ChipsService();
        }return chipsRepl;
    }
    @Override
    public Chips create(Chips chips) {
        return chipsRepInt.save(chips);
    }

    @Override
    public Chips update(Chips chips) {
        return chipsRepInt.save(chips);
    }

    @Override
    public void delete(String id) {
        chipsRepInt.deleteById(id);
    }

    @Override
    public Chips read(String id) {
        Optional<Chips> resulr=chipsRepInt.findById(id);
        return resulr.orElse(null);
    }
    @Override
    public List<Chips> readAll() {
        return chipsRepInt.findAll();
    }
    public Chips buyItem(String name){
        List<Chips>result=chipsRepInt.findAll();
        for(Chips chips:result){
            if(chips.getName().equals(name)){
                return chips;
            }
        }return null;
    }
}
