package ro.teamnet.zth.servlets;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.controllers.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iordan.Serdin on 7/20/2017.
 */
public class MyDispatcherServlet extends HttpServlet {
    Map<String,MethodAttributes> allowedMethods;

    @Override
    public void init() throws ServletException {
        try {
            allowedMethods=new HashMap<String,MethodAttributes>();
            AnnotationScanUtils.getClasses("ro.teamnet.zth.controllers");
         //   System.out.println("da");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchReply(request,response,"POST");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchReply(request,response,"GET");
    }

    public void dispatchReply(HttpServletRequest request,HttpServletResponse response,String typeParameter){
        // o sa avem dispatch(), reply, sendExceptionError
        try{
            Object resultToDisplay=dispatch(request,typeParameter);
            reply(response,resultToDisplay);
        }catch(Exception e){
            sendExceptionError();
            e.printStackTrace();
        }

    }
    private Object dispatch(HttpServletRequest request,String parameterType){
        //metoda potrivita
        EmployeeController employeeController=new EmployeeController();
        String s="";
        if (request.getRequestURI().contains("/employees")){
            s=employeeController.getAllEmployees();
            System.out.println("da");
        }
        return s;
    }
    private void reply(HttpServletResponse response,Object object) throws IOException {
        try {
            response.getWriter().write(String.valueOf(object));
            //System.out.println("da");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //return resultw
    }
    private void sendExceptionError(){
        System.out.println("Eroare");
    }


}
