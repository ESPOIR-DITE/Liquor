package company.com.service.item.impl.impl;

import company.com.domain.item.Item;
import company.com.repository.item.ItemRepInt;
import company.com.service.item.ItemServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemServiceInt {
    private static ItemService itemRep = null;
    @Autowired
    private ItemRepInt itemRepInt;
    private ItemService() {
    }

    public static ItemService getItemRep() {
        if (itemRep == null) {
            itemRep = new ItemService();
        }
        return itemRep;
    }


    @Override
    public Item create(Item item) {
        return itemRepInt.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepInt.save(item);
    }

    @Override
    public void delete(String id) {
        itemRepInt.deleteById(id);
    }

    @Override
    public Item read(String id) {
        Optional<Item> result = itemRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Item> readAll() {
        return itemRepInt.findAll();
    }

    public Item getItem(String itemName) {
        List<Item> result = itemRepInt.findAll();
        for (Item item : result) {
            if (item.getItemNamer().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
