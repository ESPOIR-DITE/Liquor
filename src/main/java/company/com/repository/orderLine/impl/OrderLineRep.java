package company.com.repository.orderLine.impl;

import java.util.ArrayList;

public class OrderLineRep{}/** implements OrderLineInt {
    private  static OrderLineRep orderLineRep=null;

    private ArrayList<OrderLine>mydb=new ArrayList<>();


    public OrderLineRep() {

    }
    public static OrderLineRep getOrderLineRep(){
        if(orderLineRep==null){
            orderLineRep=new OrderLineRep();
        }return orderLineRep;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        OrderLine result=findOrderLine(orderLine.getLineId());
        if(result==null){
            mydb.add(orderLine);
            return orderLine;
        }return null;

    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        OrderLine result=findOrderLine(orderLine.getLineId());
        if(result!=null){
           delete(result.getLineId());
            return create(orderLine);
        }return null;
    }

    @Override
    public void delete(String s) {
        OrderLine result=findOrderLine(s);
        if(result!=null){
           mydb.remove(result);
        }
    }

    @Override
    public OrderLine read(String s) {
        OrderLine result=findOrderLine(s);
        if(result!=null){
            return result;
        }return null;
    }

    @Override
    public ArrayList<OrderLine> readAll() {
        return mydb;
    }

    public OrderLine findOrderLine(String id){
        return mydb.stream()
                .filter(C ->C.getLineId().equals(id))
                .findAny()
                .orElse(null);
    }
}
*/