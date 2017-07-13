package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Iordan.Serdin on 7/12/2017.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;
    public Object getValueForQuery(Object value){
        if (value instanceof String){
            return "'"+value+"'";
        }
        if (value instanceof Date){
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";
        }
        return value.toString();
    }
   /* public QueryBuilder addCondition(Condition codition){
        //return QueryBuilder


    }*/

}
