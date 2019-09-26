package controller.item.impl.beverage.alcohol;

import controller.ControllerInt;
import domain.item.impl.beverage.Beverage;
import domain.item.impl.beverage.alcohol.Alcohol;
import domain.item.impl.beverage.alcohol.alcoholBridge.AlcoholItem;
import factory.domain.item.impl.beverage.alcohol.alcohol_bridge.Alcohol_ItemFactory;
import factory.repository.item.impl.beverage.alcohol.impl.AlcoholItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.item.impl.beverage.alcohol.alcoholBridge.AlcoholItemService;
import service.item.impl.impl.AlcoholService;
import service.item.impl.impl.BeverageService;

import java.util.ArrayList;

/**
 * this class will help for bridging between nonAlcohol, alcohol and beverage.
 */
@RestController
@RequestMapping("/beverage_bridge")
public class AlcoholController implements ControllerInt<Alcohol,String> {
    @Autowired
    AlcoholService alcoholService;
    @Autowired
    BeverageService beverageService;

    @Autowired
    AlcoholItemService alcoholItemService;


    @PostMapping("/create")
    @Override
    public Alcohol create(@RequestBody Alcohol alcohol){

        String bevId=beverageService.getBev("alcohol").getBev_id();
        Alcohol result=alcoholService.create(alcohol);
        AlcoholItem alcoholItem= Alcohol_ItemFactory.getAlcoholItem(result.getItem_id(),bevId,result.getDescription());
        alcoholItemService.create(alcoholItem);

        return result ;
    }
    @Override
    @PostMapping("/update")
    public Alcohol update(@RequestBody Alcohol alcohol){
        return alcoholService.update(alcohol);
    }
    @GetMapping("/reads")
    @Override
    public ArrayList<Alcohol> readAll() {
        return alcoholService.readAlll();
    }
    @GetMapping("/read")
    @Override
    public Alcohol read(@RequestParam String id){
        return alcoholService.read(id);
    }

    @GetMapping("/delete")
    @Override
    public void delete(@RequestParam(value = "id") String id) {
        alcoholService.delete(id);
    }

}
