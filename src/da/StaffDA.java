/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Staff;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StaffDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public StaffDA() {
        createConnection();
    }
    
    public Staff getLastRow() {
        String queryStr = "SELECT STAFF_ID FROM " + tableName+" ORDER BY STAFF_ID";
        Staff staff = null;
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                staff = new Staff(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;

    }


    public void addRecord(Staff staff) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?,?,?,?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, staff.getStaffId());
            stmt.setString(2, staff.getStaffPwd());
            stmt.setString(3, staff.getStaffName());
            stmt.setString(4, staff.getStaffIc());
            stmt.setString(5, staff.getStaffDob());
            stmt.setString(6, staff.getStaffContactnum());
            stmt.setString(7, staff.getStaffPosition());
            stmt.setString(8, staff.getStaffStatus());
            stmt.setString(9, staff.getStaffAddress());
            stmt.setString(10, staff.getStaffEmail());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void setPwd (Staff id){
        String queryStr = "UPDATE STAFF\n"
                +"SET STAFF_PWD = ? WHERE STAFF_ID = ?";
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id.getStaffPwd());
            stmt.setString(2, id.getStaffId());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void updateRecord(Staff staff) {
        String queryStr = "UPDATE STAFF\n"
                + "SET STAFF_NAME = ?, STAFF_IC = ?, STAFF_DOB = ?, STAFF_ADDRESS = ?, STAFF_CONTACTNUM = ?, STAFF_STATUS = ?, STAFF_POSITION = ?, STAFF_EMAIL = ? WHERE STAFF_ID = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, staff.getStaffName());
            stmt.setString(2, staff.getStaffIc());
            stmt.setString(3, staff.getStaffDob());
            stmt.setString(4, staff.getStaffAddress());
            stmt.setString(5, staff.getStaffContactnum());
            stmt.setString(6, staff.getStaffStatus());
            stmt.setString(7, staff.getStaffPosition());
            stmt.setString(8, staff.getStaffEmail());
            stmt.setString(9, staff.getStaffId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet retrieveRecord() {
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return rs;
    }

    public Staff getRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFF_ID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                staff = new Staff(id,rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    
    public Staff getRecordInIC(String IC) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFF_IC = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, IC);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    public ResultSet getAllRecordNoPwd() {
        String queryStr = "SELECT STAFF_ID,STAFF_NAME,STAFF_IC,STAFF_DOB,STAFF_CONTACTNUM,STAFF_POSITION,STAFF_STATUS,STAFF_ADDRESS,STAFF_EMAIL FROM " + tableName ;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
            return rs;
    }
    public Staff getRecordInID(String ID) {
        String queryStr = "SELECT STAFF_ID,STAFF_NAME,STAFF_IC,STAFF_DOB,STAFF_CONTACTNUM,STAFF_POSITION,STAFF_STATUS,STAFF_ADDRESS,STAFF_EMAIL FROM " + tableName + " WHERE STAFF_ID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
//    public Staff getRecordForViewAll(String ID) {
//        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFF_ID = ?";
//        Staff staff = null;
//        try {
//            stmt = conn.prepareStatement(queryStr);
//            stmt.setString(1, IC);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return staff;
//    }
    
    

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
