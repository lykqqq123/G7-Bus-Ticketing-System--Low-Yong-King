package control;

import da.BusDetailsDA;
import domain.BusDetailsDomain;
import java.sql.ResultSet;

public class BusDetailsControl {

    private BusDetailsDA bdDA;

    public BusDetailsControl() {
        bdDA = new BusDetailsDA();
    }
    
    public BusDetailsDomain getLastRow(){
        return bdDA.getLastRow();
    }
    public BusDetailsDomain getRecord(String busID){
        return bdDA.getRecord(busID);
    }
    public BusDetailsDomain getRecordWithBPN(String busPN){
        return bdDA.getRecordWithBPN(busPN);
    }

    public ResultSet retrieveRecord(){
        return bdDA.retrieveRecord();
    }
    public BusDetailsDomain selectRecord(String busID) {
        return bdDA.getRecord(busID);
    }
    
    public void addRecord(BusDetailsDomain bd){
        bdDA.addRecord(bd);
    }
    
    public void updateRecord(BusDetailsDomain bd){
        bdDA.updateRecord(bd);
    }

}
