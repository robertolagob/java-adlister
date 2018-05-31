import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name=request.getParameter("name");

        if (name==null){
            name="World";
        }

        response.getWriter().println("<H1>Hello"+name+"</H1>");
        response.getWriter().println("<p>Enter your name:</p>");
        response.getWriter().println("<form action=\"/hello\">");
        response.getWriter().println("<input type=\"text\" name=\"name\">");
        response.getWriter().println("</form>");

    }
}

