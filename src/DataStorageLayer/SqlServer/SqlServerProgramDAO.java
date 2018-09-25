package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.ProgramDAO;
import DataStorageLayer.Helpers.MSSQLHelper;
import DomainModelLayer.Program;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        Connection connection = MSSQLDatabase.getConnection();
        List<Program> programs = new ArrayList<Program>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String sqlQuery = "Select * FROM Programs";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {

                int subscriptionId = resultSet.getInt("Id");
                String title = resultSet.getString("Title");
                Time Duration = resultSet.getTime("Duration");
                //Add our account from resultSet to list.
                programs.add(new Program(subscriptionId, title, Duration));
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return programs;
    }

    @Override
    public Program getProgramById(int id) {

        Connection connection = MSSQLDatabase.getConnection();
        Program program = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM Programs WHERE Id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int subscriptionId = resultSet.getInt("Id");
                String title = resultSet.getString("Title");
                Time Duration = resultSet.getTime("Duration");
                //Add our account from resultSet to list.
                program = new Program(subscriptionId, title, Duration);
            }

        } catch (Exception e) {
            //Print on error.
            e.printStackTrace();
        } finally {
            //Clean our resources.
            MSSQLDatabase.closeResources(resultSet, statement, connection);
        }

        return program;
    }
}
