/**
 * HelloWorldServlet.java
 * <p>
 * Copyright (c) 2014 Teamnet. All Rights Reserved.
 * <p>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 **/

package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello World Servlet expose get method to say hello to input user
 */
public class HelloWorldServlet extends HttpServlet {

    /**
     * This method is used to map a GET request from the client side
     * @param request the HttpServletRequest instance
     * @param response the HttpServletResponse instance
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "";

        // Set the response type
        response.setContentType("text/html");
        String title = "Folosim metoda Get pentru a citi din DATA";
        PrintWriter out=response.getWriter();
        // TODO Obtain the username from the request instance



        // TODO Write the response content to the PrintWriter instance of the response instance
       // PrintWriter out=response.getWriter();
        // TIP: use write() method
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.write("<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Username:</b>: "
                + request.getParameter("user") + "\n" +

                "</ul>\n" +
                "</body> </html>");
        // TIP: you can also use html tags to markup your text


    }

}
