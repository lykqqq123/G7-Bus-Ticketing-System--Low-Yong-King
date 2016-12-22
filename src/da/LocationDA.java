package da;

import domain.BusScheduleDomain;
import domain.LocationDomain;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LocationDA {

    private String host = "jdbc:derby://localhost:1527/BUS_SYSTEM";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "LOCATION";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;

    public LocationDA() {
        createConnection();
    }

    public void addRecord(LocationDomain lct) {
        String queryStr = "INSERT INTO " + tableName + " values (?,?)";

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, lct.getLocationId());
            stmt.setString(2, lct.getLocationName());
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

    public void deleteRecord(LocationDomain location){
        String queryStr = "DELETE FROM LOCATION WHERE LOCATION_ID = ?";
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, location.getLocationId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
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
