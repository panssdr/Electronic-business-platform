package controller;


import domain.HeyTea;
import domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.HeyTeaService;
import util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HeyTeaController {

    @Autowired
    @Qualifier("heyTeaServiceImpl")
     private HeyTeaService heyTeaService;

    @RequestMapping("/manage/add")
    public String add(String pageNo, HttpServletRequest request){
        int pageNod= WebUtils.parseInt(pageNo,0);
        pageNod+=1;
        HeyTea heyTea = WebUtils.copyParamToBean(request.getParameterMap(),new HeyTea());

        heyTeaService.addHeyTea(heyTea);

       return "redirect:"+request.getContextPath()+"/manage/page?pageNo="+pageNod;
    }

    @RequestMapping("/manage/delete")
    public String delete(String id, HttpServletRequest request){
        int heyId= WebUtils.parseInt(id,0);
        heyTeaService.deleteHeyTea(heyId);

        return "redirect:"+request.getContextPath()+"/manage/page?pageNo="+request.getParameter("pageNo");
    }

    @RequestMapping("/manage/getHeyTea")
    public String getHeyTea(String id, HttpServletRequest request, Model model){
        int heyId= WebUtils.parseInt(id,0);
        HeyTea heyTea = heyTeaService.queryHeyTeaById(heyId);
        model.addAttribute("heyTea",heyTea);
        return "/pages/manager/heytea_edit";
    }


    @RequestMapping("/manage/update")
    public String update(HttpServletRequest request){
        HeyTea heyTea = WebUtils.copyParamToBean(request.getParameterMap(),new HeyTea());

        heyTeaService.updateHeyTea(heyTea);
        return "redirect:"+request.getContextPath()+"/manage/page?pageNo="+request.getParameter("pageNo");
    }


    @RequestMapping("/manage/list")
    public String list(Model model){

        List<HeyTea> heyTeas = heyTeaService.queryHeyTea();
        //通过service查询数据库中所有heytea的数据
        model.addAttribute("heyTeas",heyTeas);
        //把喜茶的数据保存在request域中

        return "/pages/manager/heytea_manager";
    }




    @RequestMapping("/manage/page")
    public String page(String pageNo,String pageSize,Model model) throws SQLException {

        //1 获取请求的参数 pageNo 和 pageSize
        int pageNos= WebUtils.parseInt(pageNo,1);
        int pageSizes= WebUtils.parseInt(pageSize, Page.PAGE_SIZE);
        //2  调用HeyTeaService.page（pageNo,pageSize):Page对象
        Page<HeyTea> page=heyTeaService.page(pageNos,pageSizes);
        //3 保存Page对象到Request域中
       model.addAttribute("page",page);

        //4 请求转发到pages/manager/
        page.setUrl("/manage/page");
        return "/pages/admin/heytea_manager";
    }
}
