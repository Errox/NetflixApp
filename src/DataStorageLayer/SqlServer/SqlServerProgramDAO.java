package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.ProgramDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Profile;
import DomainModelLayer.Program;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlServerProgramDAO implements ProgramDAO {

    private MSSQLHelper MSSQLDatabase;

    public SqlServerProgramDAO() {
        this.MSSQLDatabase = new MSSQLHelper();
    }

    //[ProgramId] [int] IDENTITY(1,1) NOT NULL,
    //[Title] [nvarchar](50) NULL,
    //[Duration] [time](7) NULL,

    @Override
    public List<Program> getAllPrograms() {
        Connection connection =  MSSQLDatabase.getConnection();
        List<Program> prgrams = new ArrayList<Program>();
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

                /*int subscriptionId = resultSet.getInt("subscriptionId");
                String name = resultSet.getString("name");
                String streetName = resultSet.getString("streetName");
                String postalCode = resultSet.getString("postalCode");
                String houseNumber = resultSet.getString("houseNumber");
                String place = resultSet.getString("place");
*/
                //Add our account from resultSet to list.
                prgrams.add(null);//new Profile(subscriptionId, name, streetName, postalCode, houseNumber, place));
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return prgrams;
    }

    @Override
    public Program getProgramById(int id) {

        Connection connection =  MSSQLDatabase.getConnection();
        Program program = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            String sqlQuery = "";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){

//                int subscriptionId = resultSet.getInt("subscriptionId");
//                String name = resultSet.getString("name");
//                String streetName = resultSet.getString("streetName");
//                String postalCode = resultSet.getString("postalCode");
//                String houseNumber = resultSet.getString("houseNumber");
//                String place = resultSet.getString("place");

                //Add our account from db to list.
                program = null;//new Account(subscriptionId, name, streetName, postalCode, houseNumber, place);
            }

        }catch (Exception e){
            //Print on error.
            e.printStackTrace();
        }finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return program;
    }
}
