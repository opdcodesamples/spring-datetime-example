package org.osmand.springdatetime;

public interface OrderService {

    public OrderBean getOrder();
    public OrderBean saveOrder(OrderBean orderBean);
    public OrderBean updateOrder(OrderBean orderBean);


}
