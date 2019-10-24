package company.com.service.item.impl.classic.impl;

import company.com.domain.item.impl.classic.impl.Snakes;
import company.com.repository.item.impl.classic.SnakesRepInt;
import company.com.service.item.impl.classic.SnakesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnakesService implements SnakesInt {
    private static SnakesService snakesRep = null;
    @Autowired
    private SnakesRepInt snakesRepInt;

    private SnakesService() {
    }

    public static SnakesService getsnakesRep() {
        if (snakesRep == null) {
            snakesRep = new SnakesService();
        }
        return snakesRep;
    }


    @Override
    public Snakes create(Snakes snakes) {
        return snakesRepInt.save(snakes);
    }

    @Override
    public Snakes update(Snakes snakes) {
        return snakesRepInt.save(snakes);
    }

    @Override
    public void delete(String id) {
        snakesRepInt.deleteById(id);
    }

    @Override
    public Snakes read(String id) {
        Optional<Snakes> result = snakesRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Snakes> readAll() {
        return snakesRepInt.findAll();
    }

    public Snakes buyItem(String name) {
        List<Snakes> result = snakesRepInt.findAll();
        for (Snakes snakes : result) {
            if (snakes.getName().equals(name)) {
                return snakes;
            }
        }
        return null;
    }
}
