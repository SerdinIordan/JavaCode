package ro.teamnet.zth.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Iordan.Serdin on 7/13/2017.
 */
public class DBManager {

    private static final String  CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";
    public DBManager() {
        throw new UnsupportedOperationException();
    }
    public static void registerDriver(){
        try{
            Class.forName(DBProperties.DRIVER_CLASS);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection c=null;
        try {
           c= DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
           if (c!=null){
               System.out.println("s-a conectat");
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;

    }
    public static void checkConnection(){
        Connection conn=getConnection();
        Statement stmt=null;
        try{
            stmt=conn.createStatement();
            /*if (stmt!=null){
                System.out.println("avem statement");
            }*/
            ResultSet rs;
            rs=stmt.executeQuery("Select * from DEPARTMENTS");
            /*if (rs!=null){
                System.out.println("avem resultset");
                System.out.println(rs.getString("JOB_ID"));
            }*/

            while (rs.next()){
                //System.out.println("da");
                System.out.println("DEPARTMENT_ID:"+rs.getInt(1));
                System.out.println("DEPARMENT_NAME:"+rs.getString(2));
                System.out.println("LOCATION_ID:"+rs.getInt(3));
               // System.out.println("MAX_SALARY"+rs.getInt(4));


            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]) {
        try {
           // Connection c=DBManager.getConnection();
            DBManager.checkConnection();
        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
