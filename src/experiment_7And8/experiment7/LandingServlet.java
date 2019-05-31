package experiment_7And8.experiment7;

import Tools.ReturnInformation.ReturnInformation;
import experiment_7And8.experiment7.Listener.Dome02Listener;
import experiment_9And10.experiment10.user.dao.implement.ImplementOperationUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LandingServlet", urlPatterns = "/experiment_7And8/experiment7/LandingServlet")
public class LandingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String liupengUserID = request.getParameter("liupengUserID");
        String liupengPassword = request.getParameter("liupengPassword");
        String landingreturnInformation = null;
        HttpSession httpSession = request.getSession();
        ImplementOperationUser implementOperationUser = new ImplementOperationUser();
        try {
            ReturnInformation returnInformation = implementOperationUser.landing(liupengUserID, liupengPassword);
            landingreturnInformation = returnInformation.getReturnInformation();
            httpSession.setAttribute("landingreturnInformation", landingreturnInformation);
            if(returnInformation.getResult().equals("success")) {
                //登陆成功
                httpSession.setAttribute("liupengUserID", liupengUserID);
                this.testAddHttpSessionBindingListener(httpSession);
                this.testSubHttpSessionBindingListener(httpSession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/experiment_7And8/experiment7/LandingResults/JSPFile/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void testAddHttpSessionBindingListener(HttpSession httpSession) {
        Dome02Listener dome02Listener = new Dome02Listener();
        httpSession.setAttribute("dome02Listener", dome02Listener);
    }

    public void testSubHttpSessionBindingListener(HttpSession httpSession) {
        httpSession.removeAttribute("dome02Listener");
    }
}
