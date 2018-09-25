package ApplicationLayer;

import DataStorageLayer.DAO.ProgramDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Program;

import java.util.List;

public class ProgramManager implements ProgramDAO {

    private ProgramDAO programDAO;

    public ProgramManager() {
        this.programDAO = DAOFactory.getProgramDAOInstance();
    }

    @Override
    public List<Program> getAllPrograms() {
        return programDAO.getAllPrograms();
    }

    @Override
    public Program getProgramById(int id) {
        return programDAO.getProgramById(id);
    }
}
