package company.com.service.item.impl.impl;

import company.com.domain.item.impl.classic.Classic;
import company.com.repository.item.ClassicRepInt;
import company.com.repository.item.impl.impl.ClassicRep;
import company.com.service.item.ClassicServoceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassicService implements ClassicServoceInt {
    private static ClassicService classicRep = null;
    @Autowired
    private ClassicRepInt classicRepInt;

    private ClassicService() {
    }

    public static ClassicService getClassicRep() {
        if (classicRep == null) {
            classicRep = new ClassicService();
        }
        return classicRep;
    }
    @Override
    public Classic create(Classic classic) {
        return classicRepInt.save(classic);
    }

    @Override
    public Classic update(Classic classic) {
        return classicRepInt.save(classic);
    }

    @Override
    public void delete(String s) {
        classicRepInt.deleteById(s);
    }

    @Override
    public Classic read(String s) {
        Optional<Classic> result = classicRepInt.findById(s);
        return result.orElse(null);
    }

    @Override
    public List<Classic> readAll() {
        return classicRepInt.findAll();
    }


}
