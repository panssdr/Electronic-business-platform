package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class DeleteController {

   @RequestMapping("/delete")
  public ModelAndView delete(String pic, HttpServletRequest request){
      ModelAndView mv=new ModelAndView();
       String fileName=pic;
       if(null==fileName || fileName.length()==0){
           //文件为空，提示用户
           mv.addObject("delete_msg","文件不能为空。");
         mv.setViewName("/pages/admin/admin_deletePic");
           return mv;
       }
       //图片存放的目录为web/upload目录,创建文件对象
       File file=new File(request.getServletContext().getRealPath("/upload/"+fileName));
       if(file.exists()) {//文件存在
           if (file.delete()) {//删除文件
               mv.addObject("delete_msg", "删除成功。");
               mv.setViewName("/pages/admin/admin_deletePic");

           } else {
               mv.addObject("delete_msg", "删除失败。");
               mv.setViewName("/pages/admin/admin_deletePic");

           }
       }
       return mv;
   }
}
