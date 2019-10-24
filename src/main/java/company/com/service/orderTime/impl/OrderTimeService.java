package company.com.service.orderTime.impl;


import company.com.domain.orderTiming.OrderTiming;
import company.com.repository.orderTime.OrderTimeRepInt;
import company.com.service.orderTime.OrderTimeInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderTimeService implements OrderTimeInt {
    @Autowired
    OrderTimeRepInt orderTimeRepInt;
    private static OrderTimeService orderTimeService;


    private OrderTimeService() {
    }
    public static OrderTimeService getOrderTimeService(){
        if(orderTimeService==null){
            orderTimeService=new OrderTimeService();
        }return orderTimeService;
    }


    @Override
    public OrderTiming create(OrderTiming orderTiming) {
        return orderTimeRepInt.save(orderTiming);
    }

    @Override
    public OrderTiming update(OrderTiming orderTiming) {
        return orderTimeRepInt.save(orderTiming);
    }

    @Override
    public void delete(String id) {
        orderTimeRepInt.deleteById(id);
    }

    @Override
    public OrderTiming read(String id) {
        Optional<OrderTiming> result=orderTimeRepInt.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<OrderTiming> readAll() {
        return orderTimeRepInt.findAll();
    }
}
