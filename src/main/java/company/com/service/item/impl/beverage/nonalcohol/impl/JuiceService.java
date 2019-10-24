package company.com.service.item.impl.beverage.nonalcohol.impl;

import company.com.domain.item.impl.beverage.nonalcohol.impl.Juice;
import company.com.repository.item.impl.beverage.nonalcohol.JuiceRepInt;
import company.com.service.item.impl.beverage.nonalcohol.JuiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuiceService implements JuiceInt {
    private static JuiceService juiceRep = null;
    @Autowired
    JuiceRepInt juiceRepInt;

    private JuiceService() {
    }

    public static JuiceService getJuiceRep() {
        if (juiceRep == null) {
            juiceRep = new JuiceService();
        }
        return juiceRep;
    }

    @Override
    public Juice create(Juice juice) {
        return this.juiceRepInt.save(juice);
    }

    @Override
    public Juice update(Juice juice) {
        return this.juiceRepInt.save(juice);
    }

    @Override
    public void delete(String id) {
        juiceRepInt.deleteById(id);
    }

    @Override
    public Juice read(String id) {
        Optional<Juice> result = juiceRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Juice> readAll() {
        return juiceRepInt.findAll();
    }

    public Juice buyItem(String name) {
        List<Juice> result = juiceRepInt.findAll();
        for (Juice juice : result) {
            if (juice.getName().equals(name)) {
                return juice;
            }
        }
        return null;
    }
}
