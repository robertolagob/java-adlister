import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(name = "HowdyServlet", urlPatterns = "/name")
public class HowdyServlet extends HttpServlet{


    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
                request.getRequestDispatcher("/name.jsp").forward(request, response);
                }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
            String name=request.getParameter("name");
            request.setAttribute("name",name);
            request.getRequestDispatcher("/Howdy.jsp").forward(request,response);
            }
}
