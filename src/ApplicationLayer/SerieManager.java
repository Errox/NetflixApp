package ApplicationLayer;

import DataStorageLayer.DAO.SerieDAO;
import DomainModelLayer.Serie;

import java.util.List;

public class SerieManager {

    private SerieDAO serieDAO;

    /**
     * Creates an instance of the serie Manager,
     * that uses the Dao specified in the constructor to
     * -Create
     * -Read
     * -Update
     * -Delete
     * @param  dao the DAO that meets the contract.
     */

    public SerieManager(SerieDAO dao){
        this.serieDAO = dao;
    }

     /**
     * -Returns all serie by the data storage layer provided.
      * */
    public List<Serie> getAllSeries(){
        return serieDAO.getAllSeries();
    }


    /**
     * -Returns serie associated by the provided id, from the storage layer provided.
     * */
    public Serie getSerieById(int id){
        return serieDAO.getSerieById(id);
    }



}
