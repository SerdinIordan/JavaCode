package ro.teamnet.zth.controllers;


import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iordan.Serdin on 7/20/2017.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
        String allEmpoyees;
    @MyRequestMethod(urlPath = "/all" ,methodType = "GET")
        public String getAllEmployees(){

            EmployeeDao employeeDao=new EmployeeDao();
            List<Employee> lista=employeeDao.getAllEmployees();
            String result="";
            for (int i=0;i<lista.size();i++){
                result=result+lista.get(i)+"   ";
            }
            return result;

        }

    @MyRequestMethod(urlPath = "/one",methodType = "GET")
        public String getOneEmployee(){
            String result="oneRandomEmployee";
            return result;

        }
}
