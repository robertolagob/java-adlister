import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name = "Calculator.jsp",urlPatterns = "/numbers")
public class Calculator  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/numbers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
        String x=req.getParameter("x");
        String y=req.getParameter("y");
        int result=0;
        String operator=req.getParameter("calculus");
        req.setAttribute("x",x);
        req.setAttribute("y",y);
        req.setAttribute("calculus",operator);
        if (operator.equals("Add")){
            result=Integer.parseInt(x)+Integer.parseInt(y);
        }
        if (operator.equals("multiply")){
            result=Integer.parseInt(x)*Integer.parseInt(y);
        }
        req.setAttribute("result",result);
        req.getRequestDispatcher("/results.jsp").forward(req,resp);



    }
}
