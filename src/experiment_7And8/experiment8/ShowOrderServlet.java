package experiment_7And8.experiment8;

import Tools.DateTime.GetDate;
import Tools.DateTime.GetTime;
import Tools.Math.StringToDouble;
import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_1And2.experiment2.Order;
import experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ShowOrderServlet", urlPatterns = "/experiment_7And8/experiment8/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String liupengGoodID = (String) httpSession.getAttribute("goodID");
        String liupengGoodNumber = request.getParameter("liupengGoodNumbers");
        String liupengUserID = request.getParameter("liupengUserID");
        PrintWriter printWriter = response.getWriter();
        ReturnInformation returnInformation = null;
        try {
            ImplementOperationGood implementOperationGood = new ImplementOperationGood();
            returnInformation = implementOperationGood.findGoodByGoodID(liupengGoodID);
            Good good = (Good) returnInformation.getObject();
            int numbers = Integer.getInteger(liupengGoodNumber);
            GetTime getTime = new GetTime();
            GetDate getDate = new GetDate();
            Order order = new Order();
            order.setGoodID(liupengGoodID);
            order.setUserID(liupengUserID);
            order.setNumber(numbers);
            order.setThe_unit_price(good.getGoodPrice());
            order.setThe_total_price(order.getThe_unit_price() * Double.valueOf(liupengGoodNumber));
            order.setDate(getDate.getMyDaye());
            order.setTime(getTime.getTime());
            returnInformation = new ReturnInformation(
                    "experiment_7And8.experiment8.ShowOrderServlet.doPost()",
                    "生成订单成功",
                    "生成订单成功",
                    "success");
            returnInformation.setType("Order");
            returnInformation.setObject(order);
            httpSession.setAttribute("returnInformation", returnInformation);
            //-------------------------------------------
            printWriter.println(liupengGoodID);
            printWriter.println(liupengGoodNumber);
            //-------------------------------------------
            response.sendRedirect("/experiment_7And8/experiment8/ShowOrder/JSPFile/index.jsp");
        } catch (SQLException e) {
            returnInformation = new ReturnInformation(
                    "experiment_7And8.experiment8.ShowOrderServlet.doPost()",
                    "生成订单失败，获取商品失败",
                    "生成订单失败",
                    "fail");
            httpSession.setAttribute("returnInformation", returnInformation);
            response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            returnInformation = new ReturnInformation(
                    "experiment_7And8.experiment8.ShowOrderServlet.doPost()",
                    "生成订单失败，获取商品失败",
                    "生成订单失败",
                    "fail");
            httpSession.setAttribute("returnInformation", returnInformation);
            response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
