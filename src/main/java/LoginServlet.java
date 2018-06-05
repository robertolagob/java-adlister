import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession user=request.getSession();
        if ((user.getAttribute("loged")==null)){
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
        else {
            response.sendRedirect("/profile");
        }
    }


//
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession user=request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = "admin".equals(username) && "password".equals(password);
        String delete=request.getParameter("close");
           if
            ("CloseSession".equalsIgnoreCase(delete)) {
                user.invalidate();
                response.sendRedirect("/login");
            }
        else {
               if ((validAttempt) && (user.getAttribute("loged") == null)) {
                   user.setAttribute("loged", "yes");
                   request.setAttribute("name",username);
                   request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
               } else {
                   response.sendRedirect("/login");
               }
           }
    }
}
