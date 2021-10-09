package service;


import domain.Cart;
import domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart, int userId) throws SQLException;
    public List<Order> showOrder(int id)throws SQLException;
    public List<Order> showOrder()throws SQLException;
    public int sendOrder(String id)throws SQLException;
    public int recieveOrder(String id) throws SQLException;
    public int sendEvaluate(String id, String evaluate)throws SQLException;
    public String showOrderEvaluate(String id) throws SQLException;
}
