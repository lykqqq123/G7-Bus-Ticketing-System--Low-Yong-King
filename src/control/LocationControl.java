package control;

import da.LocationDA;
import domain.LocationDomain;
import java.sql.ResultSet;

public class LocationControl {

    private LocationDA lctDA;

    public LocationControl() {
        lctDA = new LocationDA();
    }

    public ResultSet retrieveRecord(){
        return lctDA.retrieveRecord();
    }
    
    public void addRecord(LocationDomain lct){
        lctDA.addRecord(lct);
    }
    
    public void deleteRecord(LocationDomain lct){
        lctDA.deleteRecord(lct);
    }

}
