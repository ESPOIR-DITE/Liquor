package company.com.factory.domain.item;


import company.com.domain.item.Item;
import company.com.util.IdGenerator;

public class ItemFactory {
   public static Item getItem(String itemNumber, String itemBranch){
       return new Item.Builder(itemNumber)
               .buildId(IdGenerator.getSuffixFromClassName(Item.class))
               .buildItemBranch(itemBranch)
               .build();
   }
    public static Item updateItem(String id,String itemNumber, String itemBranch){
        return new Item.Builder(itemNumber)
                .buildId(id)
                .buildItemBranch(itemBranch)
                .build();
    }
}
