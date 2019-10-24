package company.com.service.item.impl.classic.impl;


import company.com.domain.item.impl.classic.impl.Cigarate;
import company.com.repository.item.impl.classic.CigarateRepInt;
import company.com.repository.item.impl.classic.impl.CigarateRep;
import company.com.service.item.impl.classic.CigarateInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CigarateService implements CigarateInt {

    @Autowired
    CigarateRepInt cigarateRepInt;
    private static CigarateService cigarateRep=null;
    private CigarateService() {
    }
public static CigarateService getCigarateRep(){
        if(cigarateRep==null){
            cigarateRep=new CigarateService();
        }return cigarateRep;
}


    @Override
    public Cigarate create(Cigarate cigarate) {
        return this.cigarateRepInt.save(cigarate);
    }

    @Override
    public Cigarate update(Cigarate cigarate) {
        return this.cigarateRepInt.save(cigarate);
    }

    @Override
    public void delete(String id) {
        cigarateRepInt.deleteById(id);
    }

    @Override
    public Cigarate read(String id) {
        Optional<Cigarate> result=cigarateRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Cigarate> readAll() {
        return cigarateRepInt.findAll();
    }
    public Cigarate buyItem(String name){
        List<Cigarate>result=cigarateRepInt.findAll();
        for(Cigarate cigarate: result){
            if(cigarate.getName().equals(name)){
                return cigarate;
            }
        }return null;
    }
}
