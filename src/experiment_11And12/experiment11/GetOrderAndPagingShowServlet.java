package experiment_11And12.experiment11;

import Tools.ReturnInformation.ReturnInformation;
import experiment_9And10.experiment10.order.dao.implement.ImplementOperationOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GetOrderAndPagingShowServlet", urlPatterns = "/experiment_11And12/experiment11/GetOrderAndPagingShowServlet")
public class GetOrderAndPagingShowServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String strPageNumber = (String) httpSession.getAttribute("pageNumber");
        int intPageNumber = Integer.parseInt(strPageNumber);
        GetPagingMaxNumber getPagingMaxNumber = new GetPagingMaxNumber();
        int maxPaging = getPagingMaxNumber.getNumber();
        ImplementOperationOrder implementOperationOrder = new ImplementOperationOrder();
        ReturnInformation returnInformation = null;
        try {
            returnInformation = implementOperationOrder.findOrderPaging(intPageNumber, maxPaging);
            if (returnInformation.getResult().equals("success")) {
                //数据获成功
                httpSession.setAttribute("returnInformation", returnInformation);
                response.sendRedirect("/experiment_11And12/experiment11/JSPFile/index.jsp");
            } else {
                returnInformation = new ReturnInformation(
                        "experiment_11And12.experiment11.GetOrderAndPagingShowServlet.doPost().34",
                        "在没在数据库中获取到订单",
                        "获取订单失败",
                        "fail");
                httpSession.setAttribute("returnInformation", returnInformation);
                response.sendRedirect("/experiment_11And12/experiment11/ErrorFile/JSPFile/index.jsp");
            }
        }
        catch (SQLException e) {
            returnInformation = new ReturnInformation(
                    "experiment_11And12.experiment11.GetOrderAndPagingShowServlet.doPost().44",
                    "在没在数据库中获取到订单",
                    "获取订单失败",
                    "fail");
            httpSession.setAttribute("returnInformation", returnInformation);
            response.sendRedirect("/experiment_11And12/experiment11/ErrorFile/JSPFile/index.jsp");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            returnInformation = new ReturnInformation(
                    "experiment_11And12.experiment11.GetOrderAndPagingShowServlet.doPost().54",
                    "在没在数据库中获取到订单",
                    "获取订单失败",
                    "fail");
            httpSession.setAttribute("returnInformation", returnInformation);
            response.sendRedirect("/experiment_11And12/experiment11/ErrorFile/JSPFile/index.jsp");
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
