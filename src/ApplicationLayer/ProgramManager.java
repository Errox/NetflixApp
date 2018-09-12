package ApplicationLayer;

import DataStorageLayer.DAO.ProgramDAO;
import DomainModelLayer.Program;

import java.util.List;

public class ProgramManager implements ProgramDAO {

    private ProgramDAO programDAO;

    public ProgramManager(ProgramDAO programDAO){
        this.programDAO = programDAO;
    }

    @Override
    public List<Program> getAllPrograms() {
        return null;
    }

    @Override
    public Program getProgramById(int id) {
        return null;
    }
}
