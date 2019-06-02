package experiment_7And8.experiment8.Filter;

import Tools.ReturnInformation.ReturnInformation;
import experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "GoodIDFilter", urlPatterns = "/experiment_7And8/experiment8/AddOrder/JSPFile/index.jsp")
public class GoodIDFilter implements Filter {
    public void destroy() {
        // 在 Filter 实例被 Web 容器从服务移除之前调用
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession httpSession = httpServletRequest.getSession();
        String goodID = httpServletRequest.getParameter("goodID");
        ImplementOperationGood implementOperationGood = new ImplementOperationGood();
        try {
            ReturnInformation returnInformation = implementOperationGood.goodIsExistence(goodID);
            if (returnInformation.getResult().equals("success")) {
                //商品存在
                //防止过滤俩次
                String requestURI = httpServletRequest.getRequestURI();
                System.out.println(requestURI);
                if (requestURI.contains("favicon.ico")) {
                    return;
                }
                returnInformation = implementOperationGood.



                //返回过滤链
                chain.doFilter(req, resp);
            } else {
                //商品不存在
                returnInformation = new ReturnInformation(
                        "experiment_7And8.experiment8.Filter.GoodIDFilter.doFilter()",
                        "商品存在性出错",
                        "严重商品失败",
                        "fail");
                httpServletRequest.removeAttribute("returnInformation");
                httpSession.setAttribute("returnInformation", returnInformation);
                httpServletResponse.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
            }
        } catch (SQLException e) {
            ReturnInformation returnInformation = new ReturnInformation(
                    "experiment_7And8.experiment8.Filter.GoodIDFilter.doFilter()",
                    "商品存在性出错",
                    "严重商品失败",
                    "fail");
            httpServletRequest.removeAttribute("returnInformation");
            httpSession.setAttribute("returnInformation", returnInformation);
            httpServletResponse.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            ReturnInformation returnInformation = new ReturnInformation(
                    "experiment_7And8.experiment8.Filter.GoodIDFilter.doFilter()",
                    "严重商品存在性出错",
                    "严重商品失败",
                    "fail");
            httpServletRequest.removeAttribute("returnInformation");
            httpSession.setAttribute("returnInformation", returnInformation);
            httpServletResponse.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
            e.printStackTrace();
        }
        // 把请求传回过滤链
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        // 初始化



    }

}
