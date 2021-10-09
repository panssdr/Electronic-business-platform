package dao;

import domain.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemMapper {
    public int saveOrderItem(OrderItem orderItem) throws SQLException;
    public List<OrderItem> showOrderItem(String id)throws SQLException;
}
