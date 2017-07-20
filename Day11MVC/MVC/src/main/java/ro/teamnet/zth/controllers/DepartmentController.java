package ro.teamnet.zth.controllers;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Iordan.Serdin on 7/20/2017.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
    String allDepartments;
    @MyRequestMethod(urlPath = "/all",methodType = "GET")
    public String getAllDepartments(){
        DepartmentDao departmentDao=new DepartmentDao();
        List<Department> lista=departmentDao.findAllDepartments();
        String result="";
        for (int i=0;i<lista.size();i++){
            result=result+lista.get(i)+"   ";
        }
        return result;

    }
    @MyRequestMethod(urlPath = "/one",methodType = "GET")
    public String getOneDepartment(){
        String result="oneRandomDepartment";
        return result;

    }


}
