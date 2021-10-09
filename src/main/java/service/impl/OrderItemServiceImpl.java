package service.impl;


import dao.OrderItemMapper;
import domain.OrderItem;
import service.OrderItemService;

import java.sql.SQLException;
import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemMapper orderItemMapper;

    public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public List<OrderItem> showOrder(String id) throws SQLException {
        return  orderItemMapper.showOrderItem(id);
    }
}
