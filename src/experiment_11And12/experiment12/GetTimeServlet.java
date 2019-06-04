package experiment_11And12.experiment12;

import Tools.DateTime.GetDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetTimeServlet", urlPatterns = "/experiment_11And12/experiment12/GetTimeServlet")
public class GetTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetDateTime getDateTime = new GetDateTime();
        String datetime = getDateTime.getDateTime();
        PrintWriter printWriter = response.getWriter();
        printWriter.println(datetime);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
