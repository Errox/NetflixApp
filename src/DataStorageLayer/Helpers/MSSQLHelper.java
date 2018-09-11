package DataStorageLayer.Helpers;

import javax.xml.transform.Result;
import java.sql.*;


public class MSSQLHelper {
    private static Connection connection;
    private static final String connectionString = "jdbc:sqlserver://AXR;databaseName=Bibliotheek;integratedSecurity=true;";

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void closeResources(ResultSet resultSet, Statement statement){
        closeStatementResources(statement);
        closeResultSetResources(resultSet);
    }

    public void closeStatementResources(Statement statement){
        if(statement != null){
            try{
                statement.close();
            }
            catch (Exception ignore){

            }
        }
    }
    public void closeResultSetResources(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }
            catch (Exception ignore){

            }
        }
    }
}