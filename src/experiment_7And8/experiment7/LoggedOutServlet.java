package experiment_7And8.experiment7;

import Tools.ReturnInformation.ReturnInformation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoggedOutServlet", urlPatterns = "/experiment_7And8/experiment7/LoggedOutServlet")
public class LoggedOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession httpSession = request.getSession();
        ServletContext servletContext = request.getServletContext();
        String liupengUserID = (String) httpSession.getAttribute("liupengUserID");
        printWriter.println("<h1>\n" +
                                    liupengUserID +
                                "    退出登陆\n" +
                                "</h1>");
        this.testSubHttpSessionBindingListener(httpSession);
        this.testSubServletContextListener(servletContext);
        this.testSubServletRequestAttributeListener(request);
        httpSession.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void testSubHttpSessionBindingListener(HttpSession httpSession) {
        httpSession.removeAttribute("dome02Listener");
    }

    public void testSubServletContextListener(ServletContext servletContext) {
        servletContext.removeAttribute("newObject");
    }

    public void testSubServletRequestAttributeListener(HttpServletRequest httpServletRequest) {
        httpServletRequest.removeAttribute("requestName");
    }
}
