package experiment_7And8.experiment8.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "GoodIDFilter", urlPatterns = "/experiment_7And8/experiment8/AddOrder/JSPFile/index.jsp")
public class GoodIDFilter implements Filter {
    public void destroy() {
        // 在 Filter 实例被 Web 容器从服务移除之前调用
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("使用过滤器");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession httpSession = httpServletRequest.getSession();

        // 把请求传回过滤链
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        // 初始化



    }

}
