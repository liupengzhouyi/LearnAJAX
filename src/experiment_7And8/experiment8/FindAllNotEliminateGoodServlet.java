package experiment_7And8.experiment8;

import Tools.ReturnInformation.ReturnInformation;
import experiment_1And2.experiment2.Good;
import experiment_9And10.experiment10.good.dao.Interface.OperationGood;
import experiment_9And10.experiment10.good.dao.implement.ImplementOperationGood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindAllNotEliminateGoodServlet", urlPatterns = "/experiment_7And8/experiment8/FindAllNotEliminateGoodServlet")
public class FindAllNotEliminateGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Good> list = null;
        HttpSession httpSession = request.getSession();
        OperationGood operationGood = new ImplementOperationGood();
        try {
            ReturnInformation returnInformation = operationGood.findAllNotEliminateGood();
            if (returnInformation.getResult().equals("success1")) {
                list = (List<Good>) returnInformation.getObject();
                httpSession.setAttribute("list", list);
                response.sendRedirect("/experiment_7And8/experiment8/ShowAllGood/JSPFile/index.jsp");
            } else {
                httpSession.setAttribute("returnInformation",this.createReturnInformation());
                response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            httpSession.setAttribute("returnInformation",this.createReturnInformation());
            response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            httpSession.setAttribute("returnInformation",this.createReturnInformation());
            response.sendRedirect("/experiment_7And8/experiment8/ErrorFile/JSPFile/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public ReturnInformation createReturnInformation() {
        ReturnInformation returnInformation = new ReturnInformation(
                "experiment_7And8.experiment8.FindAllNotEliminateGoodServlet",
                "获取未下架商品信息失败",
                "获取未下架商品信息失败",
                "fail");
        return returnInformation;
    }
}
