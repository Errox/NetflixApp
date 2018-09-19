package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.SerieDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Serie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SqlServerSerieDAO implements SerieDAO {

    //[SerieId] [int] IDENTITY(1,1) NOT NULL,
    //[Name] [nvarchar](50) NULL,
    //[age] [int] NULL,
    //[Language] [nvarchar](50) NULL,
    //[Genre] [nvarchar](50) NULL,
    private MSSQLHelper MSSQLDatabase;

    public SqlServerSerieDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    @Override
    public List<Serie> getAllSeries() {
        List<Serie> series = new ArrayList<Serie>();
        List<Map<String, Object>> queryResult = null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Serie");

        for (int i = 0; i < queryResult.size(); i++) {
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Serie serie = null;//new Serie(1, "", new Date(), "", "");

            series.add(serie);
        }

        return series;
    }

    @Override
    public Serie getSerieById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Serie serie = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                int length = resultSet.getInt("length");
                String name = resultSet.getString("name");
                String language = resultSet.getString("length");
                String genre = resultSet.getString("language");

                //Add our account from db to list.
                serie = new Serie(name, length,language, genre);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return serie;
    }

}
