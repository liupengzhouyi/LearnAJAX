package experiment_11And12.experiment11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "NextPagingServlet", urlPatterns = "/experiment_11And12/experiment11/NextPagingServlet")
public class NextPagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String strPageNumber = (String) httpSession.getAttribute("pageNumber");
        int intPageNumber = Integer.parseInt(strPageNumber);
        System.out.println(intPageNumber);
        GetMaxPaging getMaxPaging = null;
        try {
            getMaxPaging = new GetMaxPaging();
            int maxPaging = getMaxPaging.getmaxPaging();
            System.out.println(maxPaging);
            if (intPageNumber < maxPaging) {
                intPageNumber = intPageNumber + 1;
            }
            httpSession.setAttribute("pageNumber","" + intPageNumber);
            response.sendRedirect("/experiment_11And12/experiment11/GetOrderAndPagingShowServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
