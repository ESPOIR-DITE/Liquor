package company.com.service.item.impl.classic.impl;


import company.com.domain.item.impl.classic.impl.Ice;
import company.com.repository.item.impl.classic.IceRepInt;
import company.com.repository.item.impl.classic.impl.IceRep;
import company.com.service.item.impl.classic.IceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IceService implements IceInt {
@Autowired
IceRepInt iceRepInt;
    private static IceService iceRep;
    private IceService() {
    }
public static IceService getIceRep(){
        if(iceRep==null){
            iceRep=new IceService();
        }return iceRep;
}


    @Override
    public Ice create(Ice ice) {
        return iceRepInt.save(ice);
    }

    @Override
    public Ice update(Ice ice) {
        return iceRepInt.save(ice);
    }

    @Override
    public void delete(String id) {
        iceRepInt.deleteById(id);

    }

    @Override
    public Ice read(String id) {
        Optional<Ice> result=iceRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Ice> readAll() {
        return iceRepInt.findAll();
    }
    public Ice buyItem(String name){
        List<Ice>result=iceRepInt.findAll();
        for(Ice ice:result){
            if(ice.getName().equals(name)){
                return ice;
            }
        }return null;
    }
}
