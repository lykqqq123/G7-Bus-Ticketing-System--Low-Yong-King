/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import da.StaffDA;
import domain.Staff;
import java.sql.ResultSet;

public class MaintainStaffControl {

    private StaffDA staffDA;

    public MaintainStaffControl() {
        staffDA = new StaffDA();
    }
     public Staff getRecord(String staffID){
        return staffDA.getRecord(staffID);
    }

    public Staff getRecordInWithIC(String IC){
        return staffDA.getRecordInIC(IC);
    }
    public Staff getRecordInID(String ID){
        return staffDA.getRecordInID(ID);
    }
    public ResultSet retrieveRecord(){
        return staffDA.retrieveRecord();
    }
    public ResultSet getAllRecordNoPwd(){
        return staffDA.getAllRecordNoPwd();
    }
    public Staff selectRecord(String id) {
        return staffDA.getRecord(id);
    }
    
    public void addRecord(Staff staff){
        staffDA.addRecord(staff);
    }
    public void setPwd(Staff id){
        staffDA.setPwd(id);
    }
    
    public void updateRecord(Staff staff){
        staffDA.updateRecord(staff);
    }
    
    public Staff getLastRow(){
        return staffDA.getLastRow();
    }
    
}
