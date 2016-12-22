/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import da.CardDetailsDA;
import domain.CustcardDetails;
import java.sql.ResultSet;

/**
 *
 * @author Student
 */
public class CustCardDetailsControl {
        private CardDetailsDA cdDA;

    public CustCardDetailsControl() {
        cdDA = new CardDetailsDA();
    }
    public void addRecord(CustcardDetails cd){
        cdDA.addRecord(cd);
    }
    public CustcardDetails getLastRow(){
        return cdDA.getLastRow();
    }
}



