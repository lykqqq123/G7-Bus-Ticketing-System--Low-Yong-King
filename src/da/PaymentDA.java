package da;

import control.MaintainStaffControl;
import control.TransactionControl;
import domain.PaymentDetails;
import domain.Staff;
import domain.TransactionDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PaymentDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PAYMENT_DETAILS";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public PaymentDA() {
        createConnection();
    }

    public PaymentDetails getLastRow() {
        String queryStr = "SELECT PAYCOUNT_ID FROM " + tableName+" ORDER BY PAYCOUNT_ID";
        PaymentDetails pd = null;
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                pd = new PaymentDetails(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pd;

    }
    public PaymentDetails getLastRowWithPaymentID() {
        String queryStr = "SELECT * FROM " + tableName+" ORDER BY PAYMENT_ID";
        PaymentDetails pd = null;
        TransactionControl tControl = new TransactionControl();
        MaintainStaffControl msControl = new MaintainStaffControl();
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                TransactionDetails td = tControl.getRecord(rs.getString(7));
                Staff st = msControl.getRecord(rs.getString(8));
                pd = new PaymentDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),Double.parseDouble(rs.getString(1)),td,st);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pd;

    }

    public void addRecord(PaymentDetails pd) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?,?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, pd.getPaycountId());
            stmt.setString(2, pd.getPaymentId());
            stmt.setString(3, pd.getPaymentDate());
            stmt.setString(4, pd.getPaymentTime());
            stmt.setString(5, pd.getPaymentType());
            stmt.setDouble(6, pd.getTotalAmount());
            stmt.setString(7, pd.getTranstId().getTranstId());
            stmt.setString(8, pd.getStaffId().getStaffId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateRecord(PaymentDetails pd) {
        String queryStr = "UPDATE BUS_DETAILS\n"
                + "SET PAYMENT_ID = ?, PAYMENT_DATA = ?, PAYMENT_TIME = ?, PAYMENT_TYPE = ?, TOTAL_AMOUNT = ?, TRANST_ID = ?, STAFF_ID = ? WHERE PAYCOUNT_ID = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(8, pd.getPaycountId());
            stmt.setString(1, pd.getPaymentId());
            stmt.setString(2, pd.getPaymentDate());
            stmt.setString(3, pd.getPaymentTime());
            stmt.setString(4, pd.getPaymentType());
            stmt.setDouble(5, pd.getTotalAmount());
            stmt.setString(6, pd.getTranstId().getTranstId());
            stmt.setString(7, pd.getStaffId().getStaffId());
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

    public PaymentDetails getRecord(String payCountID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYCOUNT_ID = ?";
        PaymentDetails pd = null;
        TransactionDetails td = null;
        Staff st = null;
        MaintainStaffControl sControl = new MaintainStaffControl();
        TransactionControl tControl = new TransactionControl();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, payCountID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                td = tControl.getRecord(rs.getString(7));
                st = sControl.getRecord(rs.getString(8));
                pd  = new PaymentDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Double.parseDouble(rs.getString(6)), td, st);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pd;
    }
    public PaymentDetails getRecordWithPaymentID(String paymentID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENT_ID = ?";
        PaymentDetails pd = null;
        TransactionDetails td = null;
        Staff st = null;
        MaintainStaffControl sControl = new MaintainStaffControl();
        TransactionControl tControl = new TransactionControl();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, paymentID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                td = tControl.getRecord(rs.getString(7));
                st = sControl.getRecord(rs.getString(8));
                pd  = new PaymentDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Double.parseDouble(rs.getString(6)), td, st);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pd;
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
