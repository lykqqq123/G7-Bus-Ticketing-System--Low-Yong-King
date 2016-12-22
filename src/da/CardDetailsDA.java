/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.CustcardDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CardDetailsDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CUSTCARD_DETAILS";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public CardDetailsDA() {
        createConnection();
    }

    public void addRecord(CustcardDetails cd) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, cd.getCustcardId());
            stmt.setString(2, cd.getCardNum());
            stmt.setString(3, cd.getExpMonth());
            stmt.setString(4, cd.getExpYear());
            stmt.setString(5, cd.getCvv());
            stmt.setString(6, cd.getNameOnCard());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public CustcardDetails getLastRow() {
        String queryStr = "SELECT CUSTCARD_ID FROM " + tableName+" ORDER BY CUSTCARD_ID";
        CustcardDetails cd = null;
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                cd = new CustcardDetails(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cd;

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
