package experiment_11And12.experiment11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PreviousPagingServlet", urlPatterns = "/experiment_11And12/experiment11/PreviousPagingServlet")
public class PreviousPagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String strPageNumber = (String) httpSession.getAttribute("pageNumber");
        int intPageNumber = Integer.parseInt(strPageNumber);
        if(intPageNumber == 0) {
            intPageNumber = 0;
        } else {
            intPageNumber = intPageNumber -1;
        }
        httpSession.setAttribute("pageNumber","" + intPageNumber);
        response.sendRedirect("/experiment_11And12/experiment11/GetOrderAndPagingShowServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
