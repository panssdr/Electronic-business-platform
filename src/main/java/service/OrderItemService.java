package service;

import domain.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemService {
    public List<OrderItem> showOrder(String id)throws SQLException;
}
