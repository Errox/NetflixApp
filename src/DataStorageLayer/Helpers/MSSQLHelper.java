package DataStorageLayer.Helpers;

import java.sql.*;
import java.util.Map;


public class MSSQLHelper implements  SqlHelper{

    private static MSSQLHelper instance;
    private static Connection connection;
    private static final String connectionString = "jdbc:sqlserver://AXR;databaseName=NetFlix;integratedSecurity=true;";

    public MSSQLHelper() {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResources(ResultSet resultSet, Statement statement){
        if(resultSet != null){
            try{
                resultSet.close();
            }
            catch (Exception ignore){

            }
        }
        if(statement != null){
            try{
                statement.close();
            }
            catch (Exception ignore){

            }
        }
    }



    // !!-ATTENTION-!!
    // This is not safe against SQL Injection.
    // RAW QUERIES shouldn't be executed by USER.
    // ONLY BY BUSINESS LAYER
    private ResultSet baseSql(String sql){
        ResultSet resultSet = null;
        Statement statement = null;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(resultSet, statement);
        }

        return resultSet;
    }

    @Override
    public ResultSet executeQuery(String sqlQuery) {
       return baseSql(sqlQuery);
    }

    @Override
    public ResultSet execReadTable(String tableName) {
        return baseSql("SELECT * FROM " + tableName);
    }

    @Override
    public ResultSet execReadTableWhere(String tableName, Map<String, Object> valuesToMatch) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            StringBuilder SQLQueryBuilder = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");

            for (int i = 0; i < valuesToMatch.size(); i++) {
                SQLQueryBuilder.append(valuesToMatch.keySet().toArray()[i] + " = ? AND ");
            }

            //Something should be deleted at the end?
            //SQLQueryBuilder.delete()

            preparedStatement = connection.prepareStatement(SQLQueryBuilder.toString());

            for (int i = 0; i < valuesToMatch.size(); i++) {
                preparedStatement.setString(i + 1, valuesToMatch.values().toArray()[i].toString());
            }

            resultSet = preparedStatement.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(resultSet, preparedStatement);
        }


        return resultSet;
    }

    @Override
    public ResultSet execUpdateTableWhere(String tableName, Map<String, Object> oldValue, Map<String, Object> newValue) {
        //        PreparedStatement preparedStatement = null;
        //        ResultSet resultSet = null;
        //
        //        try {
        //            StringBuilder SQLQueryBuilder = new StringBuilder("SELECT * FROM " + tableName + " WHERE ");
        //
        //            for (int i = 0; i < valuesToMatch.size(); i++) {
        //                SQLQueryBuilder.append(valuesToMatch.keySet().toArray()[i] + " = ? AND ");
        //            }
        //
        //            //SQLQueryBuilder.delete()
        //
        //            preparedStatement = connection.prepareStatement(SQLQueryBuilder.toString());
        //
        //            for (int i = 0; i < valuesToMatch.size(); i++) {
        //                preparedStatement.setString(i + 1, valuesToMatch.values().toArray()[i].toString());
        //            }
        //
        //            resultSet = preparedStatement.executeQuery();
        //
        //        }catch (Exception e){
        //            e.printStackTrace();
        //        } finally {
        //            closeResources(resultSet, preparedStatement);
        //        }
        //
        //
        //        return resultSet;
        return null;
    }

    @Override
    public boolean execDeleteByVal(String tableName, Map<String, Object> valuesToMatch) {
        PreparedStatement preparedStatement = null;

        try {
            StringBuilder SQLQueryBuilder = new StringBuilder("DELETE FROM " + tableName + " WHERE ");


            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources(null, preparedStatement);
        }

        return false;
    }


//    private List<Map<String, Object>> convertResultSetToList(ResultSet rs) throws SQLException {
//        ResultSetMetaData metaData = rs.getMetaData();
//        List<Map<String, Object>> mapArrayList = new ArrayList<>();
//
//        while (rs.next()) {
//            Map<String, Object> row = new HashMap<>(metaData.getColumnCount());
//            for (int i = 1; i <= metaData.getColumnCount(); ++i) {
//                row.put(metaData.getColumnName(i), rs.getObject(i));
//            }
//            mapArrayList.add(row);
//        }
//
//        return mapArrayList;
//    }

}