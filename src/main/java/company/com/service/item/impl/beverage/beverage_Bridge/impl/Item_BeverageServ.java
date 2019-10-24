package company.com.service.item.impl.beverage.beverage_Bridge.impl;


import company.com.domain.item.impl.ItemBridge.Item_beverage;
import company.com.repository.item.impl.beverage.beverage_Bridge.Beverage_ItemRepInt;
import company.com.service.item.impl.beverage.beverage_Bridge.Beverage_ItemServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Item_BeverageServ implements Beverage_ItemServiceInt {
    @Autowired
    Beverage_ItemRepInt beverage_itemRepInt;
    public static Item_BeverageServ item_beverageRepo;
    private ArrayList<Item_beverage>mydb=new ArrayList<>();


    private Item_BeverageServ() {
    }
    public static Item_BeverageServ getItem_BeverageRepo(){
        if(item_beverageRepo==null){
            item_beverageRepo=new Item_BeverageServ();
        }return item_beverageRepo;
    }


    @Override
    public Item_beverage create(Item_beverage item_beverage) {
        return beverage_itemRepInt.save(item_beverage);
    }

    @Override
    public Item_beverage update(Item_beverage item_beverage) {
        return beverage_itemRepInt.save(item_beverage);
    }

    @Override
    public void delete(String id) {
        beverage_itemRepInt.deleteById(id);
    }

    @Override
    public Item_beverage read(String id) {
        Optional<Item_beverage> result=beverage_itemRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Item_beverage> readAll() {
        return beverage_itemRepInt.findAll();
    }
}
