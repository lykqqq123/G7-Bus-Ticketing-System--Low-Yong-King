package control;

import da.TransactionDA;
import domain.TransactionDetails;
import java.sql.ResultSet;

public class TransactionControl {

    private TransactionDA tDA;

    public TransactionControl() {
        tDA = new TransactionDA();
    }
    
    public TransactionDetails getLastRow(){
        return tDA.getLastRow();
    }
    public TransactionDetails getRecord(String transtID){
        return tDA.getRecord(transtID);
    }
    public ResultSet getRecordWithTranstStatus(String transtStatus){
        return tDA.getRecordWithTranstStatus(transtStatus);
    }
    public void deleteRecord(TransactionDetails td){
        tDA.deleteRecord(td);
    }

    public ResultSet retrieveRecord(){
        return tDA.retrieveRecord();
    }
    
    public void addRecord(TransactionDetails td){
        tDA.addRecord(td);
    }
    
    public void updateRecord(TransactionDetails td){
        tDA.updateRecord(td);
    }

     public void setStatus(TransactionDetails id){
        tDA.setStatus(id);
    }
}
