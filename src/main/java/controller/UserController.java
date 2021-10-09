package controller;

import com.mchange.v2.beans.BeansUtils;
import domain.LoginItem;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import util.WebUtils;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller

public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping("/user/logout")
     public String list(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:"+request.getContextPath()+"/index.jsp";
  }

    @RequestMapping("/user/login")
    public String login(String username,String password,HttpServletRequest request,Model model) {

        User loginUser=userService.login(new User(username,password,null));
        if(loginUser==null){
          model.addAttribute("msg","用户或密码错误！");
          model.addAttribute("username",username);
          return "/pages/user/login";
        }
        else{
            request.getSession().setAttribute("user",loginUser);
            request.getSession().setAttribute("userId",loginUser.getId());
           return  "/pages/user/login_success";
        }
    }

    @RequestMapping("/user/regist")
    public String regist(String username,String password,String email,String code,HttpServletRequest request,Model model) {
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                request.setAttribute("email", email);
                request.setAttribute("msg", "用户名已存在。");
                return "/pages/user/regist";

            } else {
                User user1=new User(username, password, email);
                userService.addUsers(user1);
                System.out.println("注册成功");

                return "redirect:"+request.getContextPath()+"/pages/user/login.jsp";
            }
        } else {
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", username);

            request.setAttribute("email", email);
            System.out.println("验证码错误！");
            return "/pages/user/regist";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user/getpassword",produces = "text/html;charset=UTF-8")
    public String getpassword(String username,String email,HttpServletRequest request,Model model) {

        User loginUser=userService.getpassword(username,email);

        if(loginUser==null){
            return "用户不存在或者邮箱密码错误"+"<a herf=\"/pages/user/get_password.jsp\">返回请点击</a>";
        }
        else{

            return  "你的账号是:"+loginUser.getUsername()+"</br>"+
                    "你的密码是:"+loginUser.getPassword()+"</br>"+
                    "<a href=\"/pages/user/login.jsp\">返回登录页面</a>";
        }
    }


    @RequestMapping(value = "/user/loginItem")
    public String loginItem(String username,HttpServletRequest request,Model model) {

        LoginItem loginuser = userService.showLoginItem(username);
        request.getSession().setAttribute("loginuser",loginuser);
        return "/pages/client/login_manager";

    }

    @RequestMapping(value = "/user/update")
    public String update(HttpServletRequest request,Model model)  {

         LoginItem loginItem = new LoginItem();
         Map map=request.getParameterMap();
        try {
            BeanUtils.populate(loginItem,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.update(loginItem);
        return "/index";
    }
}
