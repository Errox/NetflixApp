package ApplicationLayer;

import DataStorageLayer.DAO.ProgramDAO;
import DataStorageLayer.Factories.DAOFactory;
import DomainModelLayer.Program;

import java.util.List;

public class ProgramManager implements ProgramDAO {

    private ProgramDAO programDAO;

    /**
     * Creates an instance of the Program Manager,
     * that uses the Dao specified in the constructor to
     * -Read all
     * -Read by ID
     */
    public ProgramManager() {
        this.programDAO = DAOFactory.getProgramDAOInstance();
    }

    /**
     * -Returns all Programs by the data storage layer provided.
     */
    @Override
    public List<Program> getAllPrograms() {
        return programDAO.getAllPrograms();
    }

    /**
     * -Returns Program associated by the provided id, from the storage layer provided.
     */
    @Override
    public Program getProgramById(int id) {
        return programDAO.getProgramById(id);
    }
}
