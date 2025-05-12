import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	String tmpname=request.getParameter("MYNAME");
    	response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello world</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> こんにちは </h1>");
        out.println("<h2>"+tmpname+"さん、こんにちは！</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}