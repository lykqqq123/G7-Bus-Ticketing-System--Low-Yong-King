package control;

import da.PaymentDA;
import domain.PaymentDetails;
import java.sql.ResultSet;

public class PaymentDetailsControl {

    private PaymentDA pDA;

    public PaymentDetailsControl() {
        pDA = new PaymentDA();
    }
    
    public PaymentDetails getLastRow(){
        return pDA.getLastRow();
    } public PaymentDetails getLastRowWithPaymentID(){
        return pDA.getLastRowWithPaymentID();
    }
    public PaymentDetails getRecord(String paymentCountID){
        return pDA.getRecord(paymentCountID);
    }
    public PaymentDetails getRecordWithPaymentID(String paymentID){
        return pDA.getRecordWithPaymentID(paymentID);
    }

    public ResultSet retrieveRecord(){
        return pDA.retrieveRecord();
    }
    
    public void addRecord(PaymentDetails pd){
        pDA.addRecord(pd);
    }
    
    public void updateRecord(PaymentDetails pd){
        pDA.updateRecord(pd);
    }

}
