package company.com.service.item.impl.beverage.nonalcohol.impl;

import company.com.domain.item.impl.beverage.nonalcohol.impl.EnergyDrink;
import company.com.repository.item.impl.beverage.nonalcohol.EnergyDrinkRepInt;
import company.com.repository.item.impl.beverage.nonalcohol.impl.EnergyDrinkRep;
import company.com.service.item.impl.beverage.nonalcohol.EnergyDrinkInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyDrinkService implements EnergyDrinkInt {
    private static EnergyDrinkService energyDrinkRep = null;
    @Autowired
    EnergyDrinkRepInt energyDrinkRepInt;

    private EnergyDrinkService() {
    }

    public static EnergyDrinkService getEnergyDrinkRep() {
        if (energyDrinkRep == null) {
            energyDrinkRep = new EnergyDrinkService();
        }
        return energyDrinkRep;
    }


    @Override
    public EnergyDrink create(EnergyDrink energyDrink) {
        return this.energyDrinkRepInt.save(energyDrink);
    }

    @Override
    public EnergyDrink update(EnergyDrink energyDrink) {
        return this.energyDrinkRepInt.save(energyDrink);
    }

    @Override
    public void delete(String id) {
        energyDrinkRepInt.deleteById(id);
    }

    @Override
    public EnergyDrink read(String id) {
        Optional<EnergyDrink> result = energyDrinkRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<EnergyDrink> readAll() {
        return energyDrinkRepInt.findAll();
    }

    public EnergyDrink buyItem(String name) {
        List<EnergyDrink> result = energyDrinkRepInt.findAll();
        for (EnergyDrink energyDrink : result) {
            if (energyDrink.getName().equals(name)) {
                return energyDrink;
            }
        }
        return null;
    }
}
