package DataStorageLayer.DAO;

import DomainModelLayer.Program;

import java.util.List;

public interface ProgramDAO {
    List<Program> getAllPrograms();
    Program getProgramById(int id);

    void addPrograms(List<Program> newPrograms);
    void updateProgram(Program oldProgram, Program newProgram);
    void deleteProgram(List<Program> deletePrograms);
}
