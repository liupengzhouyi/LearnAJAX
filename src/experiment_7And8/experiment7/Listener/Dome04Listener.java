package experiment_7And8.experiment7.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class Dome04Listener implements ServletRequestAttributeListener {

    // Public constructor is required by servlet spec
    public Dome04Listener() {
    }

    //增加属性
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
        System.out.println("增加request--->"+httpServletRequest.getAttribute("requestName"));
    }

    //删除属性
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
        System.out.println("增加request--->"+httpServletRequest.getAttribute("requestName"));
    }

    //属性替换（第二次设置同一属性）
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) srae.getServletRequest();
        System.out.println("增加request--->"+httpServletRequest.getAttribute("requestName"));
    }
}
