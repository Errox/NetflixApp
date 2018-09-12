package DataStorageLayer.SqlServer;

import DataStorageLayer.DAO.SerieDAO;
import DomainModelLayer.Serie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SqlServerSerieDAO implements SerieDAO {

    //[SerieId] [int] IDENTITY(1,1) NOT NULL,
    //[Name] [nvarchar](50) NULL,
    //[age] [int] NULL,
    //[Language] [nvarchar](50) NULL,
    //[Genre] [nvarchar](50) NULL,
    //[LooksLike] [int] NULL,

    @Override
    public List<Serie> getAllSeries() {
        List<Serie> series = new ArrayList<Serie>();
        List<Map<String, Object>> queryResult = null; //SqlHelperResultSet.getInstance().execRawQuery("SELECT * FROM Serie");

        for (int i = 0; i < queryResult.size(); i++) {
            //Store separately to Map to get values.
            Map<String, Object> objectMap = queryResult.get(i);

            //Case Sensitively retrieving by column name.
            //Should be by reflection.
            Serie serie = null;//new Serie(1, "", new Date(), "", "");

            series.add(serie);
        }

        return series;
    }

    @Override
    public Serie getSerieById(int id) {
        return null;
    }

}
