package experiment_7And8.experiment7.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class Dome02Listener implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        //Session中添加信息
        System.out.println("----------------------");
        System.out.println("| Session中添加信息    |");
        System.out.println("----------------------");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        //Session中添加信息
        System.out.println("----------------------");
        System.out.println("| Session中删除信息    |");
        System.out.println("----------------------");
    }
}
