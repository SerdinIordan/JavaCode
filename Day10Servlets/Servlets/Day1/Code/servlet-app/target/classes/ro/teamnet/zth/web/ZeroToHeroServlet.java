package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Iordan.Serdin on 7/18/2017.
 */
@MultipartConfig
public class ZeroToHeroServlet extends HttpServlet {

        String handleRequest(HttpServletRequest req) throws Exception{


            String response=null;
            response="Hello <b>"+req.getParameter("firstname")+req.getParameter("lastname") +"</b>! Enjoy Zero To Hero!!!";

            return response;

        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            response.getWriter().write(handleRequest(request));
        }catch(Exception e){
            e.printStackTrace();
        }



    }



}
