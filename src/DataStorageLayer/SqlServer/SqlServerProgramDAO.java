package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.ProgramDAO;
import DomainModelLayer.Program;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlServerProgramDAO implements ProgramDAO {

    //[ProgramId] [int] IDENTITY(1,1) NOT NULL,
    //[Title] [nvarchar](50) NULL,
    //[Duration] [time](7) NULL,

    @Override
    public List<Program> getAllPrograms() {
        List<Program> programs = new ArrayList<Program>();
        List<Map<String, Object>> queryResult =  null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Profile");

        for (int i = 0; i < queryResult.size(); i++){
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Program program = new Program(1, "", 1);

            programs.add(program);
        }

        return programs;
    }

    @Override
    public Program getProgramById(int id) {
        return null;
    }

    @Override
    public void addPrograms(List<Program> newPrograms) {

    }

    @Override
    public void updateProgram(Program oldProgram, Program newProgram) {

    }

    @Override
    public void deleteProgram(List<Program> deletePrograms) {

    }
}
