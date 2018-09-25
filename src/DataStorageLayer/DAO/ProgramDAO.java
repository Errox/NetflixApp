package DataStorageLayer.DAO;

import DomainModelLayer.Program;

import java.util.List;

public interface ProgramDAO {
    List<Program> getAllPrograms();

    Program getProgramById(int id);
}
