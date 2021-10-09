package controller;

import domain.Cart;
import domain.CartItem;
import domain.HeyTea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.HeyTeaService;
import util.WebUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    @Autowired
    @Qualifier("heyTeaServiceImpl")
    private HeyTeaService heyTeaService;

   @RequestMapping("/cart/addItem")
    public ModelAndView addItem(String id, HttpServletRequest request){
        //        System.out.println("加入成功");
        int heyId = WebUtils.parseInt(id,0);
        HeyTea heyTea = heyTeaService.queryHeyTeaById(heyId);
        CartItem cartItem =new CartItem(heyTea.getId(),heyTea.getName(),1,heyTea.getPrice(),heyTea.getPrice());

       Cart cart = (Cart) request.getSession().getAttribute("cart");
        ModelAndView modelAndView =new ModelAndView();
        if(cart==null){
            cart =new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
       request.getSession().setAttribute("lastName",cartItem.getName());
       request.getSession().setAttribute("cart",cart);
//        System.out.println(cart);
         modelAndView.setViewName("redirect:"+request.getHeader("Referer"));
         return  modelAndView;
    }

    @RequestMapping("/cart/deleteItem")
    public ModelAndView deleteItem(String id, HttpServletRequest request){
        int heyId = WebUtils.parseInt(id,0);
        ModelAndView mv=new ModelAndView();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(heyId);
            mv.setViewName("redirect:"+request.getHeader("Referer"));
        }
        return mv;
    }


    @RequestMapping("/cart/clear")
    public ModelAndView clear(HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        ModelAndView mv=new ModelAndView();
        if(cart!=null){
            cart.clear();
            mv.setViewName("redirect:"+request.getHeader("Referer"));
        }
        return mv;
    }

    @RequestMapping("/cart/updateCount")
    public ModelAndView updateCount(String id,String count, HttpServletRequest request){

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        int heyId = WebUtils.parseInt(id,0);
        int heyCount=WebUtils.parseInt(count,0);
        ModelAndView mv=new ModelAndView();
        if(cart!=null){
            cart.updateCount(heyId,heyCount);
            mv.setViewName("redirect:"+request.getHeader("Referer"));
        }
        return mv;
    }


    @RequestMapping("/showItem")
    public ModelAndView showItem(String id, HttpServletRequest request){

        HeyTea heyTea = heyTeaService.queryHeyTeaById(Integer.parseInt(id));
        ModelAndView mv = new ModelAndView();
        mv.addObject("heytea",heyTea);
        mv.setViewName("pages/client/heytea_item");
        return mv;
    }
}
