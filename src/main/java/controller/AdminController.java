package controller;


import domain.Admin;
import domain.LoginItem;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

   @RequestMapping("/admin/login")
   public ModelAndView login(String adminname,String password,HttpSession session){
       Admin admin =new Admin(adminname,password);
       ModelAndView mv=new ModelAndView();
       if(adminService.login(admin)==null){
           mv.addObject("msg","用户或密码错误！");
           mv.addObject("adminname",adminname);
           mv.setViewName("/pages/admin/login");
       }else{
       session.setAttribute("admin",admin);
        mv.setViewName("/pages/admin/manager");
       }
       return mv;
   }

  @RequestMapping("/admin/logout")
  public String logout(HttpSession session, HttpServletRequest request){
     session.removeAttribute("admin");
     return "redirect:"+request.getContextPath()+"/index.jsp";
  }


    @RequestMapping(value = "/admin/update")
    public String update(String adminName,String oldpassword,String newpassword,HttpServletRequest request,Model model)  {

        HttpSession session =request.getSession();
        Admin admin= (Admin) session.getAttribute("admin");
        if(admin.getAdminName().equals(adminName)&&admin.getAdminPwd().equals(oldpassword)){
            adminService.update(adminName,newpassword);
            request.getSession().removeAttribute("admin");
            return "/pages/admin/login";
        }
        else{
            return "/pages/admin/manager";
        }


    }
}
