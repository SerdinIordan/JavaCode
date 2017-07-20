package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Iordan.Serdin on 7/13/2017.
 */
public class EntityManagerImplTest {
    @Test
    public void testfindById(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();

        Department d=entityManagerImpl.findById(Department.class,260L);
        System.out.println(d);

    }
    @Test
    public void testfindAll(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();
        List<Department> l=entityManagerImpl.findAll(Department.class);
        System.out.println(l);
    }
    @Test
    public void testgetNextIdVal(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();
        Long max=entityManagerImpl.getNextIdVal("DEPARTMENTS","DEPARTMENT_ID");
        System.out.println(max);
    }
    @Test
    public void testInsert(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();
        Department d=new Department();
        Long pos=entityManagerImpl.getNextIdVal("DEPARTMENTS","DEPARTMENT_ID");
        d.setId(new Long(pos));
        d.setLocation(new Long(1700));
        d.setDepartmentName("ITSherdin");
        System.out.println(entityManagerImpl.insert(d));
        //Department d=entityManagerImpl.insert(Department.class);

    }


    @Test
    public void testUpdate(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();
        String departmentName="Department";
        Department d=new Department();
        d.setDepartmentName(departmentName);
        d.setId(new Long(10));
        d.setLocation(new Long(1800));
        entityManagerImpl.update(d);
    }

    @Test
    public void testDelete(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();
        Location l=new Location();
        l.setId(new Long(1000));
        entityManagerImpl.delete(l);
    }


    @Test
    public void testfindByParams(){
        EntityManagerImpl entityManagerImpl=new EntityManagerImpl();
        Map<String,Object> params=new HashMap<>();
        params.put("DEPARTMENT_ID",new Long(10));
        params.put("LOCATION_ID",new Long(1800));
        entityManagerImpl.findByParams(Department.class,params);

    }




}
