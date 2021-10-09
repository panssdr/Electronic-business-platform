package dao;


import domain.Order;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface OrderMapper {

    public int saveOrder(Order order) throws SQLException;
    public List<Order> showOrder(int id)throws SQLException;
    public List<Order> showOrder()throws SQLException;
    public int sendOrder(@Param("id") String id)throws SQLException;
    public int recieveOrder(@Param("id") String id) throws SQLException;
    public int sendEvaluate(@Param("id") String id, @Param("evaluate") String evaluate)throws SQLException;
    public String showOrderEvaluate(@Param("id") String id)throws SQLException;
}
