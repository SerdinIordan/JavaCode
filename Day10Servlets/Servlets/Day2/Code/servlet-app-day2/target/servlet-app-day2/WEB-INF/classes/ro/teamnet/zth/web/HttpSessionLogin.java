package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Iordan.Serdin on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");

        String session=request.getSession().getId();

       if ("admin".equals(request.getParameter("username"))&&"admin".equals(request.getParameter("password"))){
            out.write("<html>\n" +
                    "<head><title>" + "User si parola" + "</title></head>\n" +
                    "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + "Welcome back " + "</h1>\n" +
                    "<br>\n" +"User:  "

                    + request.getParameter("username") + "\n" +


                    "</body> </html>" +"<br>"+request.getSession().getId());
            System.out.println(request.getParameter("username"));
           System.out.println(request.getParameter("password"));
       }else{
           request.getSession().setAttribute("user",request.getParameter("username"));
           request.getSession().setAttribute("session",request.getSession());



           RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/loginFail.jsp");
            requestDispatcher.forward(request,response);

       }
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
