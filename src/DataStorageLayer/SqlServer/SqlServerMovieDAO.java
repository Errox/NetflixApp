package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.MovieDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlServerMovieDAO implements MovieDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerMovieDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    //[MovieId] [int] NOT NULL,
    //[AgeClassification] [int] NULL,
    //[Language] [nvarchar](50) NULL,
    //[Genre] [nvarchar](50) NULL,

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> accounts = new ArrayList<Movie>();
        List<Map<String, Object>> queryResult = null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Movies");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Movie movie = new Movie(1, "", "");

            accounts.add(movie);
        }
        return accounts;
    }

    @Override
    public Movie getMovieById(int id) {
        Connection connection =  MSSQLDatabase.getConnection();
        Movie movie = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
//
//                int subscriptionId = resultSet.getInt("subscriptionId");
//                String name = resultSet.getString("name");
//                String streetName = resultSet.getString("streetName");
//                String postalCode = resultSet.getString("postalCode");
//                String houseNumber = resultSet.getString("houseNumber");
//                String place = resultSet.getString("place");

                //Add our account from db to list.
                movie =null;//new Episode(subscriptionId, name, streetName, postalCode, houseNumber, place);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return movie;
    }

}
