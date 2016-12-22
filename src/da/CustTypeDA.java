package da;

import domain.CustTypeDomain;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CustTypeDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CUST_TYPE";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public CustTypeDA() {
        createConnection();
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

    public CustTypeDomain getRecord(String custID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUST_TYPE_ID = ?";
        CustTypeDomain ct = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, custID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ct = new CustTypeDomain(rs.getString(1),rs.getString(2),Double.parseDouble(rs.getString(3)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ct;
    }
    
    public CustTypeDomain getRecordWithType(String custID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE CUST_TYPE = ?";
        CustTypeDomain ct = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, custID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ct = new CustTypeDomain(rs.getString(1),rs.getString(2),Double.parseDouble(rs.getString(3)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ct;
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
