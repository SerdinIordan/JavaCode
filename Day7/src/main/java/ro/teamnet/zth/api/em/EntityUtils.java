package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */
public class EntityUtils {

    public EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) {
        Table annotation = (Table) entity.getClass().getAnnotation(Table.class);
        if (annotation == null) {
            return entity.getSimpleName();
        }
        return annotation.name();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity) throws IllegalAccessException {
        // returneaza o lista de ColumnInfo folosind @Column
        ArrayList<ColumnInfo> lista = new ArrayList<ColumnInfo>();
        Annotation[] cols = entity.getClass().getAnnotations();    //luam fiecare annotare a coloanei
        ColumnInfo c = new ColumnInfo();
      //  Object b = new Object();
        for (Field f : entity.getFields()) {


            if (f.getClass().getAnnotation(Id.class) != null) {
                c.setId(true);
            } else {
                c.setId(false);
            }
            if (f.getClass().getAnnotation(Column.class) != null) {
                c.setColumnName(f.getName());
                c.setColumnType(f.getType());
               // c.setValue(f.get(b));
            }

            lista.add(c);

        }
       /* for (Annotation a:cols){
          //Column anotare1= (Column) a.getClass().getAnnotation(Column.class);
            ColumnInfo c=new ColumnInfo();
          if (a.getClass().getAnnotation(Id.class)!=null){
                c.setId(true);
          }else{
              c.setId(false);
          }

          if (a.getClass().getAnnotation(Column.class))
        }*/

        return lista;
    }


    public static Object castFromSqlType(Object value, Class wantedType) {
        //value-valoarea din baza de date
        //wantedType-tipul valorii pe care trebuie sa il folosesti
        //cast id-ul la id field

        if (value instanceof BigDecimal && wantedType.equals(Integer.class)) {
            return new Integer(0);
        }
        if (value instanceof BigDecimal && wantedType.equals(Long.class)){
            return new Long(0);
        }
        if (value instanceof BigDecimal && wantedType.equals(Float.class)){
            return new Float(0);
        }
        if (value instanceof BigDecimal && wantedType.equals(Double.class)){
            return new Double(0);
        }
        if (!(value instanceof BigDecimal)){
            return value;
        }
    return null;

    }
    public static ArrayList<Field> getFieldsByAnnotations(Class clazz,Class annotation){
        ArrayList<Field> lista = new ArrayList<Field>(); //vectorul returnat
        Field[] fields = clazz.getFields();
        for (Field f:fields){
            if (f.getAnnotation(annotation)!=null){
                lista.add(f);
            }
        }

        return lista;
    }
    public static Object getSqlValue(Object object){
        Field[] f=object.getClass().getFields();
        if ((object.getClass().getAnnotation(Table.class)!=null)){
            for (Field h:f){
                if (h.getClass().getAnnotation(Id.class)!=null){
                    h.setAccessible(true);
                }
            }
            return object;
        }
        return null;
    }





}
