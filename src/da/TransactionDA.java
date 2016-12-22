package da;

import control.BusScheduleControl;
import control.CustTypeControl;
import domain.BusScheduleDomain;
import domain.CustTypeDomain;
import domain.TransactionDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TransactionDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "TRANSACTION_DETAILS";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public TransactionDA() {
        createConnection();
    }

    public TransactionDetails getLastRow() {
        String queryStr = "SELECT TRANST_ID FROM " + tableName+" ORDER BY TRANST_ID";
        TransactionDetails td = null;
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                td = new TransactionDetails(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return td;

    }

    public void addRecord(TransactionDetails td) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?,?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, td.getTranstId());
            stmt.setString(2, td.getScheduleId().getScheduleId());
            stmt.setString(3, td.getCustTypeId().getCustTypeId());
            stmt.setString(4, td.getPaymentStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void deleteRecord(TransactionDetails td) {
        String queryStr = "DELETE FROM TRANSACTION_DETAILS WHERE TRANST_STATUS = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, td.getTranstStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateRecord(TransactionDetails td) {
        String queryStr = "UPDATE BUS_DETAILS\n"
                + "SET SCHEDULE_ID = ?, CUST_TYPE_ID = ?, PAYMENT_STATUS = ? WHERE TRANST_ID = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, td.getScheduleId().getScheduleId());
            stmt.setString(2, td.getCustTypeId().getCustTypeId());
            stmt.setString(3, td.getPaymentStatus());
            stmt.setString(4, td.getTranstId());
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

    public TransactionDetails getRecord(String transtID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE TRANST_ID = ?";
        TransactionDetails td = null;
        BusScheduleDomain bs = null;
        CustTypeDomain ct = null;
        CustTypeControl ctControl = new CustTypeControl();
        BusScheduleControl bsControl = new BusScheduleControl();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, transtID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                bs = bsControl.getRecord(rs.getString(2));
                ct = ctControl.getRecord(rs.getString(3));
                td = new TransactionDetails(rs.getString(1),rs.getString(4),bs,ct);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return td;
    }
    
    public ResultSet getRecordWithTranstStatus(String transtStatus) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE TRANST_STATUS = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, transtStatus);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
     public void setStatus (TransactionDetails id){
        String queryStr = "UPDATE TRANSACTION_DETAILS\n"
                +"SET TRANST_STATUS = ? WHERE TRANST_ID = ?";
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id.getTranstStatus());
            stmt.setString(2, id.getTranstId());
            stmt.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
