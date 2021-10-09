package interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 在调用 Controller 之前调用
     * @param request
     * @param response
     * @return true 表示继续流程(调用下一个拦截器或处理器) false 表示中断流程, 不在调用其它拦截器或处理器, 需要通过 response 来响应。
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        // 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        // 返回false则不执行拦截
        HttpSession session = request.getSession();
        //String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
        //if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// 说明登录成功 或者 执行登录功能
        if(session.getAttribute("user")!=null) {
            // 登录成功不拦截
            return true;
        }else {
            // 拦截后进入登录页面
            response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
            return false;
        }
    }
    /**
     * 在Controller调用之后, DispatcherServlet返回渲染视图之前被调用, 可操作ModelAndView对象对试图进行渲染操作。
     * 注意: ModelAndView对象有可能为null
     * @param request
     * @param response
     * @param obj
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
        // 在处理过程中，执行拦截
    }

    /**
     * 在视图渲染完毕后调用
     * @param request
     * @param response
     * @param obj
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {
        // 执行完毕，返回前拦截
    }
}
