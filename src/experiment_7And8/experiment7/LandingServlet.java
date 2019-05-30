package experiment_7And8.experiment7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LandingServlet", urlPatterns = "/experiment_7And8/experiment7/LandingServlet")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String liupengUserID = request.getParameter("liupengUserID");
        String liupengPassword = request.getParameter("liupengPassword");
        System.out.println(liupengUserID);
        System.out.println(liupengPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
