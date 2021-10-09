package controller;

import domain.Cart;
import domain.Order;
import domain.OrderItem;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OrderItemService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    @Autowired
    @Qualifier("orderItemServiceImpl")
    private OrderItemService orderItemService;

    /**
     * 生成订单
     *
     * @param
     * @param
     * @throws ServletException
     * @throws IOException
     */

     @RequestMapping("/order/createOrder")
     public String createOrder( Model model, HttpServletRequest request) throws SQLException {
           Cart cart= (Cart) request.getSession().getAttribute("cart");
         User loginUser = (User) request.getSession().getAttribute("user");
        if(loginUser==null){
            return "/pages/user/login";
        }


         Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,Userid);生成订单
         String orderId = orderService.createOrder(cart, userId);

         request.getSession().setAttribute("orderId",orderId);
          return  "redirect:"+request.getContextPath()+"/pay";
     }



    @RequestMapping("/order/showOrder")
    public String showOrder( Model model, HttpServletRequest request) throws SQLException {
        User user = (User) request.getSession().getAttribute("user");
         List<Order> orders=orderService.showOrder(user.getId());
       request.getSession().setAttribute("orders",orders);
        return  "redirect:"+request.getContextPath()+"/pages/order/order.jsp";
    }



    @RequestMapping("/order/showOrders")
    public String showOrders(  Model model, HttpServletRequest request) throws SQLException {
        List<Order> orderss=orderService.showOrder();
        request.getSession().setAttribute("orderss",orderss);
        return  "redirect:"+request.getContextPath()+"/pages/admin/order_manager.jsp";
    }

    @RequestMapping("/order/showOrderItem")
    public String showOrderItem(String orderid,String real,Model model, HttpServletRequest request) throws SQLException {
        List<OrderItem> orderItems=orderItemService.showOrder(orderid);
        request.getSession().setAttribute("orderItems",orderItems);
        request.getSession().setAttribute("orderId",orderid);
        request.getSession().setAttribute("real",real);
        return  "redirect:"+request.getContextPath()+"/pages/order/orderItem.jsp";
    }




    @RequestMapping("/order/recieveOrderItem")
    public String recieveOrderItem(String orderid,Model model, HttpServletRequest request) throws SQLException {
        orderService.recieveOrder(orderid);
        request.getSession().setAttribute("order_recieve_id",orderid);
        return  "redirect:"+request.getContextPath()+"/pages/order/orderRecieve.jsp";
    }

    @RequestMapping("/order/sendOrder")
    public String sendOrder(String orderrId,Model model, HttpServletRequest request) throws SQLException {
        System.out.println(orderrId+"1234566");
        orderService.sendOrder(orderrId);
        List<Order> orderss=orderService.showOrder();
        request.getSession().setAttribute("orderss",orderss);

        return  "redirect:"+request.getContextPath()+"/pages/admin/order_manager.jsp";
    }

    @RequestMapping("/order/sendEvaluate")
    public String sendEvaluate(String evaluate,String recieveId, HttpServletRequest request) throws SQLException {
        orderService.sendEvaluate(recieveId,evaluate);

        return  "redirect:"+request.getContextPath()+"/pages/user/login_success.jsp";
    }


    @RequestMapping("/order/showOrderEvaluate")
    public String showOrderEvaluate(String orderid,Model model,  HttpServletRequest request) throws SQLException {
        String evaluate=orderService.showOrderEvaluate(orderid);
        System.out.println(evaluate);
        request.getSession().setAttribute("evaluate",evaluate);
        request.getSession().setAttribute("evaluate_order_id",orderid);

        return  "redirect:"+request.getContextPath()+"/pages/admin/order_show_evaluate.jsp";
    }
}
