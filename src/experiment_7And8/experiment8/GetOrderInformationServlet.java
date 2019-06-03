package experiment_7And8.experiment8;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "GetOrderInformationServlet", urlPatterns = "/experiment_7And8/experiment8/GetOrderInformationServlet")
public class GetOrderInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        ReturnInformation returnInformation = (ReturnInformation) httpSession.getAttribute("returnInformation");
        if(returnInformation.getResult().equals("fail")) {
            //获取订单失败
            returnInformation = new ReturnInformation(
                    "/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp",
                    "在添加订单时发生了错误",
                    "添加订单失败",
                    "fail");
            // 添加错误信息到Session
            httpSession.setAttribute("returnInformation", returnInformation);
            // 转发到错误页面
            response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
        }
        else {
            //获取订单成功
            Order order = (Order) returnInformation.getObject();
            ImplementOperationOrder implementOperationOrder = new ImplementOperationOrder();
            try {
                returnInformation = implementOperationOrder.addOrder(order);
                if (returnInformation.getResult().equals("fail")) {
                    // 添加订单失败！
                    // 添加错误信息到Session
                    httpSession.setAttribute("returnInformation", returnInformation);
                    // 转发到错误页面
                    response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
                } else {
                    //添加订单成功！
                    returnInformation = new ReturnInformation(
                            "/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp",
                            "添加订单成功",
                            "添加订单成功",
                            "success");
                    // 添加成功信息到Session
                    httpSession.setAttribute("returnInformation", returnInformation);
                    // 转发到成功页面
                    response.sendRedirect("/experiment_7And8/experiment8/Success/JSPFile/index.jspp");
                }
            }
            catch (SQLException e) {
                returnInformation = new ReturnInformation(
                        "/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp",
                        "在添加订单时发生了错误",
                        "添加订单失败",
                        "fail");
                // 添加错误信息到Session
                httpSession.setAttribute("returnInformation", returnInformation);
                // 转发到错误页面
                response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                returnInformation = new ReturnInformation(
                        "/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp",
                        "在添加订单时发生了错误",
                        "添加订单失败",
                        "fail");
                // 添加错误信息到Session
                httpSession.setAttribute("returnInformation", returnInformation);
                // 转发到错误页面
                response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
