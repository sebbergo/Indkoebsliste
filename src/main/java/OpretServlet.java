import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "OpretServlet", urlPatterns = {"/OpretServlet"})
public class OpretServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if(((Map<String, String>)(servletContext.getAttribute("brugerMap"))).containsKey(navn)){

            request.setAttribute("besked", "Navnet du angav er allerede brugt!!");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);
        }

        ((Map<String, String>)(servletContext.getAttribute("brugerMap"))).put(navn, kodeord);
        request.setAttribute("besked", "Du er oprettet og klar til at logge in");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
