import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(name = "PickColor", urlPatterns = "/color")
public class PickColorServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
        request.getRequestDispatcher("/color.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String color=request.getParameter("color");
        request.setAttribute("color",color);
        request.getRequestDispatcher("/ColorShow.jsp").forward(request,response);

    }
}

