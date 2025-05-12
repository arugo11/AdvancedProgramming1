import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Plus23088 extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException 
    {
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        int result = 0;

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        result = num1 + num2;


        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>計算結果は、" + result + "です。</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
