package DA;

import control.BusDetailsControl;
import domain.BusDetailsDomain;
import domain.BusScheduleDomain;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class BusScheduleDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BUS_SCHEDULE";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public BusScheduleDA() {
        createConnection();
    }

    public BusScheduleDomain getLastRow() {
        String queryStr = "SELECT SCHEDULE_ID FROM " + tableName+" ORDER BY SCHEDULE_ID";
        BusScheduleDomain bs = null;
        try {
            statement =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(queryStr);
            
            if(rs.last()){
                bs = new BusScheduleDomain(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bs;

    }

    public void addRecord(BusScheduleDomain bs) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?,?,?,?,?,?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bs.getScheduleId());
            stmt.setString(2, bs.getScheduleDate());
            stmt.setString(3, bs.getScheduleTime());
            stmt.setInt(4, bs.getAvailableSeat());
            stmt.setDouble(5, bs.getPrice());
            stmt.setString(6, bs.getDepartLocation());
            stmt.setString(7, bs.getArriveLocation());
            stmt.setString(8, bs.getBusId().getBusId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateRecord(BusScheduleDomain bs) {
        String queryStr = "UPDATE BUS_SCHEDULE\n"
                + "SET SCHEDULE_DATE = ?, SCHEDULE_TIME = ?, AVAILABLE_SEAT = ?, PRICE = ?, DEPART_LOCATION = ?, ARRIVE_LOCATION = ?, BUS_ID = ? WHERE SCHEDULE_ID = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bs.getScheduleDate());
            stmt.setString(2, bs.getScheduleTime());
            stmt.setInt(3, bs.getAvailableSeat());
            stmt.setDouble(4, bs.getPrice());
            stmt.setString(5, bs.getDepartLocation());
            stmt.setString(6, bs.getArriveLocation());
            stmt.setString(7, bs.getBusId().getBusId());
            stmt.setString(8, bs.getScheduleId());
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

    public BusScheduleDomain getRecord(String scheduleID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SCHEDULE_ID = ?";
        BusScheduleDomain busSchedule = null;
        BusDetailsDomain busDetails = null;
        BusDetailsControl bsControl = new BusDetailsControl();
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, scheduleID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                busDetails = bsControl.getRecord(rs.getString(8));
                busSchedule = new BusScheduleDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getDouble(5), rs.getString(6), rs.getString(7),busDetails);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busSchedule;
    }
    public BusScheduleDomain getRecordWithBST(String busST) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SCHEDULE_TIME = ?";
        BusScheduleDomain busSchedule = null;
        BusDetailsDomain busDetails = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, busST);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                busDetails.setBusId(rs.getString(8));
                busSchedule = new BusScheduleDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getDouble(5), rs.getString(6), rs.getString(7),busDetails);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busSchedule;
    }
    public BusScheduleDomain getRecordWithBSD(String busSD) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SCHEDULE_DATE = ?";
        BusScheduleDomain busSchedule = null;
        BusDetailsDomain busDetails = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, busSD);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                busDetails.setBusId(rs.getString(8));
                busSchedule = new BusScheduleDomain(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getDouble(5), rs.getString(6), rs.getString(7),busDetails);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busSchedule;
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
