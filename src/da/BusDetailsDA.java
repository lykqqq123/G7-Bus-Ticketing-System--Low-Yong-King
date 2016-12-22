package da;

import domain.BusDetailsDomain;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BusDetailsDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BUS_DETAILS";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public BusDetailsDA() {
        createConnection();
    }

    public BusDetailsDomain getLastRow() {
        String queryStr = "SELECT BUS_ID FROM " + tableName+" ORDER BY BUS_ID";
        BusDetailsDomain bd = null;
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                bd = new BusDetailsDomain(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bd;

    }

    public void addRecord(BusDetailsDomain bd) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bd.getBusId());
            stmt.setString(2, bd.getBusPlateNum());
            stmt.setString(3, bd.getBusColour());
            stmt.setString(4, bd.getBusStatus());
            stmt.setInt(5, (int) bd.getTotalSeat());
            stmt.setString(6, bd.getDescription());
            stmt.setString(7, bd.getBusType());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateRecord(BusDetailsDomain bd) {
        String queryStr = "UPDATE BUS_DETAILS\n"
                + "SET BUS_PLATE_NUM = ?, BUS_COLOUR = ?, BUS_STATUS = ?, TOTAL_SEAT = ?, DESCRIPTION = ?, BUS_TYPE = ? WHERE BUS_ID = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bd.getBusPlateNum());
            stmt.setString(2, bd.getBusColour());
            stmt.setString(3, bd.getBusStatus());
            stmt.setInt(4, (int) bd.getTotalSeat());
            stmt.setString(5, bd.getDescription());
            stmt.setString(6, bd.getBusType());
            stmt.setString(7, bd.getBusId());
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

    public BusDetailsDomain getRecord(String busID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BUS_ID = ?";
        BusDetailsDomain busDetails = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, busID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                busDetails = new BusDetailsDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busDetails;
    }
    public BusDetailsDomain getRecordWithBPN(String busPN) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BUS_PLATE_NUM = ?";
        BusDetailsDomain busDetails = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, busPN);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                busDetails = new BusDetailsDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busDetails;
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
