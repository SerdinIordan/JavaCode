package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnNames = EntityUtils.getColumns(entityClass);
        List<Field> listFields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);  //vrea sa vada daca sunt si alte id-uri
        //  System.out.println("field"+listFields.get(0).getName());
        //select * from tablename where fieldId=id  listFields .length>1
        Condition condition = new Condition();
        if (listFields.size() > 1) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            condition.setColumnName(columnNames.get(0).getDbColumnName());

            // System.out.println(listFields.get(0).getName());
            condition.setValue(id);
        }
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columnNames);
        queryBuilder.setQueryType(QueryType.SELECT);
        queryBuilder.addCondition(condition);
        String query = queryBuilder.createQuery();
        // System.out.println(query);


        //create Statement
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                T t = entityClass.newInstance(); //instance de tip tabela
                for (ColumnInfo c : columnNames) {
                    // obtain the field c.getColumnName();
                    Field f = t.getClass().getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    Object b = rs.getObject(c.getDbColumnName());

                    //  f.set(t,Long.parseLong(b.toString()));
                    f.set(t, EntityUtils.castFromSqlType(b, f.getType()));

                }
                return t;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) {
        Connection connection = DBManager.getConnection();
        Statement stmt;
        //Long max=new Long(0);
        //Object max = new Object();
        Long max=new Long(0);
        Long p = null;
        try {
            String sql="select max("+columnIdName+") from " + tableName;
            stmt=connection.createStatement();
           // stmt = connection.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()) {

                max=rs.getLong(1)+1;
               // p = (Long) max + 1;
                System.out.println("max"+max);

            }
            //p = (Long) max + 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }

    @Override
    public <T> Object insert(T entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columnNames = EntityUtils.getColumns(entity.getClass());
        List<Field> listFields = EntityUtils.getFieldsByAnnotations(entity.getClass(), Id.class);
        Long pos = new Long(0);
        try {
            for (ColumnInfo columnInfo : columnNames) {
                if (columnInfo.getClass().isAnnotationPresent(Id.class)) {
                   // pos = getNextIdVal(tableName, columnInfo.getColumnName());
                    Field f1 = entity.getClass().getField(columnInfo.getColumnName());
                  //  f1.set(entity, entity.getClass().getField(columnInfo.getDbColumnName()));
                    columnInfo.setValue(f1.get(entity));
                } else {
                    Field f2 = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                    f2.setAccessible(true);
                    columnInfo.setValue(f2.get(entity));
                    //columnInfo.setValue(f.get(entity));

                    //f2.set(entity, entity.getClass().getDeclaredField(columnInfo.getColumnName()));
                }
            }
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setTableName(tableName);
            queryBuilder.addQueryColumns(columnNames);
            queryBuilder.setQueryType(QueryType.INSERT);
            String query = queryBuilder.createQuery();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(query);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return findById(entity.getClass(), pos);

    }



    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection connection = DBManager.getConnection();
        System.out.println(entityClass.getClass());
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnNames = EntityUtils.getColumns(entityClass);
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columnNames);
        queryBuilder.setQueryType(QueryType.SELECT);
        String query = queryBuilder.createQuery();
        try {


            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<T> lista = new ArrayList<T>();
            while (rs.next()) {
                T t = entityClass.newInstance(); //instanta
                for (ColumnInfo c : columnNames) {
                    Field f = t.getClass().getDeclaredField(c.getColumnName());
                    f.setAccessible(true);
                    Object b = rs.getObject(c.getDbColumnName());

                    //  f.set(t,Long.parseLong(b.toString()));
                    f.set(t, EntityUtils.castFromSqlType(b, f.getType()));

                }
                lista.add(t);

            }
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    //map<String,Object> numele valoarea
    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        Connection connection = DBManager.getConnection();
        System.out.println(entityClass.getClass());
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnNames = EntityUtils.getColumns(entityClass);
        QueryBuilder queryBuilder = new QueryBuilder();
        List<Condition> listaConditii = new ArrayList<Condition>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            Condition condition = new Condition();
            condition.setColumnName(entry.getKey());
            condition.setValue(entry.getValue());
            listaConditii.add(condition);

        }
        //introducem fiecare conditie in query
        for (Condition condition : listaConditii) {
            queryBuilder.addCondition(condition);
        }

        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columnNames);
        queryBuilder.setQueryType(QueryType.SELECT);

        String query = queryBuilder.createQuery();
        System.out.println(query);

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<T> lista = new ArrayList<T>();
            while (rs.next()) {
                T t = entityClass.newInstance(); //instanta
                for (ColumnInfo columnInfo : columnNames) {
                    Field f = t.getClass().getDeclaredField(columnInfo.getColumnName());
                    f.setAccessible(true);
                    Object b = rs.getObject(columnInfo.getDbColumnName());

                    //  f.set(t,Long.parseLong(b.toString()));
                    f.set(t, EntityUtils.castFromSqlType(b, f.getType()));

                }
                lista.add(t);

            }
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public <T> T update(T entity) {
        Connection connection = DBManager.getConnection();
        ResultSet rs = null;
        Statement stmt = null;
        String tableName = EntityUtils.getTableName(entity.getClass());
        System.out.println("tablename" + tableName);
        List<ColumnInfo> columnNames = EntityUtils.getColumns(entity.getClass());
        System.out.println("columnNames" + columnNames);

        try {
            stmt = connection.createStatement();
            for (ColumnInfo columnInfo : columnNames) {
                Field f = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                f.setAccessible(true);
                columnInfo.setValue(f.get(entity));
            }
            Condition condition = new Condition();
            condition.setColumnName(columnNames.get(0).getDbColumnName());
            condition.setValue(columnNames.get(0).getValue());
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setTableName(tableName);
            queryBuilder.setQueryType(QueryType.UPDATE);
            queryBuilder.addQueryColumns(columnNames);
            queryBuilder.addCondition(condition);
            String query = queryBuilder.createQuery();
            System.out.println(query);
            rs = stmt.executeQuery(query);
            System.out.println(query);
            connection.commit();

            return findById((Class<T>) entity.getClass(), (Long) columnNames.get(0).getValue());


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void delete(Object entity) {
        Connection connection = DBManager.getConnection();
        ResultSet rs = null;
        Statement stmt = null;
        String tableName = EntityUtils.getTableName(entity.getClass());
        System.out.println("tablename" + tableName);
        List<ColumnInfo> columnNames = EntityUtils.getColumns(entity.getClass());
        System.out.println("columnNames" + columnNames);

        try {
            stmt = connection.createStatement();
            for (ColumnInfo c : columnNames) {
                Field f = entity.getClass().getDeclaredField(c.getColumnName());
                f.setAccessible(true);
                c.setValue(f.get(entity));
            }
            Condition condition = new Condition();
            condition.setColumnName(columnNames.get(0).getDbColumnName());
            condition.setValue(columnNames.get(0).getValue());
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setTableName(tableName);
            queryBuilder.setQueryType(QueryType.DELETE);
            queryBuilder.addQueryColumns(columnNames);
            queryBuilder.addCondition(condition);
            String query = queryBuilder.createQuery();
            System.out.println(query);
            rs = stmt.executeQuery(query);
            System.out.println(query);
            connection.commit();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
