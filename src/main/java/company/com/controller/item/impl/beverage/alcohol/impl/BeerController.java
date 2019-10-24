package company.com.controller.item.impl.beverage.alcohol.impl;

import company.com.controller.ControllerInt;
import company.com.domain.item.buy.Buy;
import company.com.domain.item.impl.beverage.alcohol.Alcohol;
import company.com.domain.item.impl.beverage.alcohol.alcoholBridge.AlcoholItem;
import company.com.domain.item.impl.beverage.alcohol.impl.Beer;
import company.com.domain.itemTrensaction.ItemStock;
import company.com.domain.orderBuilder.Orders;
import company.com.domain.orderLine.OrderLine;
import company.com.factory.domain.item.impl.beverage.alcohol.alcohol_bridge.Alcohol_ItemFactory;
import company.com.factory.domain.itemTransaction.ItemStockFactory;
import company.com.factory.domain.orderFactory.OrderFacto;
import company.com.factory.domain.orderLine.OrderLineFactory;
import company.com.service.itemTrensaction.ItemStockService;
import company.com.service.orderLine.impl.OrderLineService;
import company.com.service.orderServices.impl.OrderServices;
import company.com.util.time.currentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import company.com.service.item.impl.beverage.alcohol.alcoholBridge.AlcoholItemService;
import company.com.service.item.impl.beverage.alcohol.impl.BeerService;
import company.com.service.item.impl.impl.AlcoholService;
import company.com.service.item.impl.impl.BeverageService;
import company.com.service.item.impl.impl.ItemService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerController implements ControllerInt<Beer,String> {
    @Autowired
    ItemService itemService;
    @Autowired
    BeverageService beverageService;
    @Autowired
    AlcoholService alcoholService;
    @Autowired
    BeerService beerService;
    @Autowired
    AlcoholItemService alcoholItemService;
    @Autowired
    ItemStockService itemStockService;
    @Autowired
    OrderServices orderServices;
    @Autowired
    OrderLineService orderLineService;

    @PostMapping("/create")
    @Override
    public Beer create(@RequestBody Beer beer){
        Beer result =beerService.create(beer);
        return result;
    }

    @GetMapping("/read")
    @Override
    public Beer read(@RequestParam(value = "id") String id) {
        return beerService.read(id);
    }

    @GetMapping("/delete")
    @Override
    public void delete(@RequestParam(value = "id") String id) {
        beerService.delete(id);
    }

    @PostMapping("/update")
    @Override
    public Beer update(@RequestBody Beer beer) {
        return beerService.update(beer);
    }

    @GetMapping("/reads")
    @Override
    public List<Beer> readAll() {
        return beerService.readAll();
    }
    @PostMapping("/buy")
    /**
     * when we buying
     * (String itemId,double itemPrice,int quantity,String descrption
     */
    public Buy buyItem(@RequestBody Buy buy){
        Beer beer=beerService.selItem(buy.getItemName(),buy.getSize());
        if(beer!=null&&beer.getQuantity()<buy.getQuantity()){
            ItemStock itemStock= ItemStockFactory.getItemStock(beer.getId(),beer.getPrice(),buy.getQuantity(),buy.getDescription());
            itemStockService.create(itemStock);

            //creating an order
            Orders order= OrderFacto.getOrders(buy.getCustomer(), currentTime.getTime(),buy.getDescription());
            if(order!=null) {
                orderServices.create(order);

                //creating orderLine
                OrderLine orderLine= OrderLineFactory.getOrderLine(order.getOrderNumeber(),beer.getId());
                orderLineService.create(orderLine);
                //if goes well
                if(orderLine!=null){
                    return buy;
                }

            }
        }
        return null;
    }
}
