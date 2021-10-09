package controller;


import domain.HeyTea;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.HeyTeaService;
import util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class ClientHeyTeaController {

    @Autowired
    @Qualifier("heyTeaServiceImpl")
    private HeyTeaService heyTeaService;


    @RequestMapping("/clientHeyTea/page")
    public ModelAndView indexPage(HttpServletRequest request) throws SQLException {

         ModelAndView mv =new ModelAndView("/pages/client/index");
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo= WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize= WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2  调用HeyTeaService.page（pageNo,pageSize):Page对象
        Page<HeyTea> page=heyTeaService.page(pageNo,pageSize);
        //3 保存Page对象到Request域中

        page.setUrl("/clientHeyTea/page");
         mv.addObject("page",page);
        //4 请求转发到pages/manager/
        return mv;
    }

    @RequestMapping("/clientHeyTea/pageByPrice")
    public ModelAndView pageByPrice(HttpServletRequest request) throws SQLException {
        //1 获取请求的参数 pageNo 和 pageSize
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo= WebUtils.parseInt(request.getParameter("pageNo"),1);
        int pageSize= WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max =WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);

        //2  调用HeyTeaService.page（pageNo,pageSize):Page对象
        Page<HeyTea> page=heyTeaService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder st=new StringBuilder("/clientHeyTea/pageByPrice");
        if(request.getParameter("min")!=null){
            st.append("?min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max")!=null){
            st.append("?max=").append(request.getParameter("max"));
        }
        //3 保存Page对象到Request域中
        page.setUrl(st.toString());
        //4 请求转发到pages/manager/

         ModelAndView mv = new ModelAndView("/pages/client/index");
     mv.addObject("page",page);
       return  mv;
    }

}
