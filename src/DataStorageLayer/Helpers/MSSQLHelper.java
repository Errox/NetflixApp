package DataStorageLayer.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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

    public void closeResources(ResultSet resultSet, Statement statement) {
        closeStatementResources(statement);
        closeResultSetResources(resultSet);
    }

    public void closeResources(ResultSet resultSet, Statement statement, Connection connection) {
        closeStatementResources(statement);
        closeResultSetResources(resultSet);
        closeConnectionResource(connection);
    }

    public void closeConnectionResource(Connection connection) {
        if(connection != null){
            try{
                connection.close();
            }
            catch (Exception ignore){

            }
        }
    }

    public void closeStatementResources(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception ignore) {

            }
        }
    }

    public void closeResultSetResources(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception ignore) {

            }
        }
    }
}