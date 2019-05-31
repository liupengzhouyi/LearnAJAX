package experiment_7And8.experiment7.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@WebListener()
public class Dome03Listener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public Dome03Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    // 初始化函数
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("----------------------");
        System.out.println("| context中添加信息    |");
        System.out.println("----------------------");
        ServletContext sct = sce.getServletContext();
        sct.setAttribute("ContextInformation", "ContextInformation");

    }

    // 销毁函数
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("----------------------");
        System.out.println("| context中删除信息    |");
        System.out.println("----------------------");
        ServletContext sct = sce.getServletContext();
        sct.removeAttribute("ContextInformation");
    }
}
