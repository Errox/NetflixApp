package DataStorageLayer.Helpers;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface SqlHelper{

    ResultSet executeQuery(String sqlQuery);

    ResultSet execReadTable(String tableName);
    ResultSet execReadTableWhere(String tableName, Map<String, Object> valuesToMatch);

    ResultSet execUpdateTableWhere(String tableName, Map<String, Object> oldValue, Map<String, Object> newValue);

    boolean execDeleteByVal(String tableName, Map<String, Object> valuesToMatch);

}
