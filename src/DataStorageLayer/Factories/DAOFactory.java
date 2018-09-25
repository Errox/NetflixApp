package DataStorageLayer.Factories;

import DataStorageLayer.DAO.*;
import DataStorageLayer.SqlServer.*;


public class DAOFactory {

    public static AccountDAO getAccountDAOInstance() {
        return new SqlServerAccountDAO();
    }

    public static EpisodeDAO getEpisodeDAOInstance() {
        return new SqlServerEpisodeDAO();
    }

    public static MovieDAO getMovieDAOInstance() {
        return new SqlServerMovieDAO();
    }

    public static ProfileDAO getProfileDAOInstance() {
        return new SqlServerProfileDAO();
    }

    public static ProgramDAO getProgramDAOInstance() {
        return new SqlServerProgramDAO();
    }

    public static SerieDAO getSerieDAOInstance() {
        return new SqlServerSerieDAO();
    }

    public static WatchedDAO getWatchedDAOInstance() {
        return new SqlServerWatchedDAO();
    }
}
