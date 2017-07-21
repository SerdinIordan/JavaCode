package ro.teamnet.zth;

import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.fmk.MethodAttributes;
import ro.teamnet.zth.fmk.domain.BeanKey;
import ro.teamnet.zth.fmk.domain.HttpMethod;
import ro.teamnet.zth.utils.BeanDeserializator;
import ro.teamnet.zth.utils.ControllerScanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class Z2HDispatcherServlet extends HttpServlet {
    private ControllerScanner controllerScanner;

    @Override
    public void init() throws ServletException {
        controllerScanner = new ControllerScanner("ro.teamnet.zth.appl.controller");
        controllerScanner.scan();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.GET);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.POST);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.DELETE);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.PUT);
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, HttpMethod methodType) {
        try {
            Object resultToDisplay = dispatch(req, methodType);
            reply(resp, resultToDisplay);
        } catch (Exception e) {
            try {
                sendExceptionError(e, resp);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    private void sendExceptionError(Exception e, HttpServletResponse resp) throws IOException {
        resp.getWriter().print(e.getMessage());
    }

    private void reply(HttpServletResponse resp, Object resultToDisplay) {
        //todo serialize the output(resultToDisplay=controllerinstance.invokeMethod(paramenters))
        // into JSON using ObjectMapper
        String result = "";  //final
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            result=objectMapper.writeValueAsString(resultToDisplay);
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Object dispatch(HttpServletRequest req, HttpMethod methodType) {
        //todo to invoke the controller method for the curent request and return
        // the controller output
        //vom afla la inceput cheia
        try {
            //vom lua metodele atribute
            MethodAttributes methodAttributes;

            methodAttributes = controllerScanner.getMetaData(req.getPathInfo(), methodType);
            Object object=methodAttributes.getControllerClass().newInstance();
            Method method=methodAttributes.getMethod();
            return  method.invoke(object, BeanDeserializator.getMethodParams(method,req).toArray());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
