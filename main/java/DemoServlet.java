import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLClassLoader;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.*;

@WebServlet("/DemoServlet")

public class DemoServlet extends HttpServlet {

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World Kosta!</h3>");
    }*/

    private String getClasspathString() {

        StringBuffer classpath = new StringBuffer();

        ClassLoader applicationClassLoader = this.getClass().getClassLoader();
        if (applicationClassLoader == null) {
            applicationClassLoader = ClassLoader.getSystemClassLoader();
        }
        URL[] urls = ((URLClassLoader) applicationClassLoader).getURLs();

        for (int i = 0; i < urls.length; i++) {
            classpath.append(urls[i].getFile()).append("\r\n");
        }

        return classpath.toString();
    };

    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
        {


            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();
            String name = req.getParameter("name");

            //Check session:
            HttpSession sess = req.getSession(true);
            ServletContext context = sess.getServletContext();

            pw.println("Class path is: " + getClasspathString()+ "<br>");
            pw.println("System class path is: " + System.getProperty("java.class.path"));

            //
            //pw.println("<h3> Welcome </h3>"+name);
        }
};