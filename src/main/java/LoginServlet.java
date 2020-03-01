import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null){

            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");
            brugerMap.put("admin", "1234");

            servletContext.setAttribute("brugerMap", brugerMap);

        }

        if(!((Map<String, String>)servletContext.getAttribute("brugerMap")).containsKey(navn)){
            //todo gå til logind side
            request.setAttribute("besked", "Opret dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);

        }

        if(((Map<String, String>)servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)){

            if(navn.equalsIgnoreCase("admin")){
                //todo gå til adminside
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
            }

            response.getWriter().println("klar til login - alt er fint!!");
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request, response);
        }

        //todo gå til login

        request.setAttribute("besked", "Dit login er forkert, prøv igen...");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
