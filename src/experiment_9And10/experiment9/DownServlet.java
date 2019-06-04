package experiment_9And10.experiment9;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "DownServlet", urlPatterns = "/experiment_9And10/experiment9/DownServlet")
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取想要下载的文件名
        String fileName = request.getParameter("filename");
        //将文件名进行转码，防止出现中文乱码
        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        //设置文件所在路径（context对象的getRealPath方法能够获得Web应用的所在目录）
        //getRealPath方法能够获得项目的运行目录，通过给定字符串能够获得包含给定虚拟路径的绝对路径
        String path = this.getServletContext().getRealPath("/WEB-INF/upload")+"/"+fileName;
        System.out.println(path);
        //创建File对象，通过指定路径获取想要下载的文件
        File file = new File(path);
        //如果文件不存在
        if(!file.exists()){
            request.setAttribute("message", "该资源不存在！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //设置响应正文的MIME类型,控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        in.close();  //关闭文件输入流
        out.close(); //关闭输出流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
