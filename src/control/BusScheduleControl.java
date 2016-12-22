package control;

import DA.BusScheduleDA;
import domain.BusScheduleDomain;
import java.sql.ResultSet;

public class BusScheduleControl {

    private BusScheduleDA bsDA;

    public BusScheduleControl() {
        bsDA = new BusScheduleDA();
    }
    
    public BusScheduleDomain getLastRow(){
        return bsDA.getLastRow();
    }
    public BusScheduleDomain getRecord(String scheduleID){
        return bsDA.getRecord(scheduleID);
    }
    public BusScheduleDomain getRecordWithBST(String busST){
        return bsDA.getRecordWithBST(busST);
    }
    public BusScheduleDomain getRecordWithBSD(String busSD){
        return bsDA.getRecordWithBSD(busSD);
    }

    public ResultSet retrieveRecord(){
        return bsDA.retrieveRecord();
    }
    public BusScheduleDomain selectRecord(String scheduleID) {
        return bsDA.getRecord(scheduleID);
    }
    
    public void addRecord(BusScheduleDomain bs){
        bsDA.addRecord(bs);
    }
    
    public void updateRecord(BusScheduleDomain bs){
        bsDA.updateRecord(bs);
    }

}
