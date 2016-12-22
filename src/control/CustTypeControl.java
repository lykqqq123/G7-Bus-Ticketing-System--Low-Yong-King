package control;

import da.CustTypeDA;
import domain.CustTypeDomain;
import java.sql.ResultSet;

public class CustTypeControl {

    private CustTypeDA ctDA;

    public CustTypeControl() {
        ctDA = new CustTypeDA();
    }
    
    public CustTypeDomain getRecord(String custID){
        return ctDA.getRecord(custID);
    }
    
        public CustTypeDomain getRecordWithType(String custType){
        return ctDA.getRecord(custType);
    }

    public ResultSet retrieveRecord(){
        return ctDA.retrieveRecord();
    }

}
