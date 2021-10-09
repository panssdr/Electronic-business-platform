package service.impl;


import dao.HeyTeaMapper;
import dao.OrderItemMapper;
import dao.OrderMapper;
import domain.*;
import service.OrderService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {


    private HeyTeaMapper heyTeaMapper;
    private OrderMapper orderMapper;
    private OrderItemMapper orderItemMapper;

    public void setHeyTeaMapper(HeyTeaMapper heyTeaMapper) {
        this.heyTeaMapper = heyTeaMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public String createOrder(Cart cart, int userId) throws SQLException {
        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(), 0,userId);
        // 保存订单
        orderMapper.saveOrder(order);

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemMapper.saveOrderItem(orderItem);

            // 更新库存和销量
            HeyTea heyTea = heyTeaMapper.queryHeyTeaById(cartItem.getId());
            heyTea.setSales( heyTea.getSales() + cartItem.getCount() );
            heyTea.setStock( heyTea.getStock() - cartItem.getCount() );
            heyTeaMapper.updateHeyTea(heyTea);

        }
        // 清空购物车
        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> showOrder(int id)throws SQLException {
        return orderMapper.showOrder(id);
    }

    @Override
    public List<Order> showOrder() throws SQLException {
        return orderMapper.showOrder();
    }

    @Override
    public int sendOrder(String id) throws SQLException {
        return orderMapper.sendOrder(id);
    }

    @Override
    public int recieveOrder(String id) throws SQLException {
        return orderMapper.recieveOrder(id);
    }

    @Override
    public int sendEvaluate(String id, String evaluate) throws SQLException {
        return orderMapper.sendEvaluate(id,evaluate);
    }

    @Override
    public String showOrderEvaluate(String id) throws SQLException {
        return orderMapper.showOrderEvaluate(id);
    }


}
