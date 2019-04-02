package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {
    }

    private static Order createOrder(){
        Order order = new Order(100,new Date(),false,null,"Dnepr","Ukraine","Buy");
        return order;
    }


    private static Order createOrderAndCallMethods(){
        Order order = new Order(100,new Date(),true,new Date(),"Kiev","Ukraine","SomeValue");

        return order;

    }
}
