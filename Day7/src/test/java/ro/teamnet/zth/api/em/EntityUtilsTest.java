package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "Department", tableName);
    }
    @Test
    public void testCastForSqlType(){
        BigDecimal b=new BigDecimal(3);
        Integer a=new Integer(0);
        assertEquals("mesaj",new Integer(0),EntityUtils.castFromSqlType(b,a.getClass()));
        Long a1=new Long(0);
        assertEquals("mesaj",new Long(0),EntityUtils.castFromSqlType(b,a1.getClass()));
        Float a2=new Float(0);
        assertEquals("mesaj",new Float(0),EntityUtils.castFromSqlType(b,a2.getClass()));
        Double a3=new Double(0);
        assertEquals("mesaj",new Double(0),EntityUtils.castFromSqlType(b,a3.getClass()));
       // String s=new String("ion");
       // assertEquals("mesaj",);



    }




}
