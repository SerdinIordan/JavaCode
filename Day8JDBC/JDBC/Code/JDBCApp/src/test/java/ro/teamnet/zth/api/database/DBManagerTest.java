package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Iordan.Serdin on 7/13/2017.
 */
public class DBManagerTest {
    @Test
    public void testgetConnection() throws Exception{

        //DBManager dbManager=new DBManager();
        //DBManager.getConnection();
        DBManager.checkConnection();
    }
    /*public void testcheckConnection() throws Exception{
        Connection c=DBManager.getConnection();
        DBManager.checkConnection(c);
    }*/
}
