import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "Guess",urlPatterns = "/guess")
public class Guess extends HttpServlet{
    int counter=0;
    int random = (int) Math.floor(Math.random()*10);  // Valor entre M y N, ambos incluidos.

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        request.getRequestDispatcher("/guess.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String message ="default message";
        String number= request.getParameter("number");

            if (Integer.parseInt(number) != random) {
                if (Integer.parseInt(number) < random) {
                    message = "too low, try Again";
                }
                if (Integer.parseInt(number) > random) {
                    message = "too high, try Again";
                }
                counter += 1;
                request.setAttribute("message",message);
                request.setAttribute("counter",counter);
                request.getRequestDispatcher("/guess.jsp").forward(request,response);
            }
            if (Integer.parseInt(number) == random) {
                message = "Great, that's the number. Your attempts: " + counter;
                counter = 0;
                random = (int) Math.floor(Math.random() * 10);
                request.setAttribute("message",message);
                request.getRequestDispatcher("/guessed.jsp").forward(request,response);
            }




    }

}
