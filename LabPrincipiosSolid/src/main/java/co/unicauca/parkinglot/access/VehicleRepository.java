
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Erazo, Juan Sanchez
 * 
 */
public class VehicleRepository implements IVehicleRepository{
    
    private Connection conn;
    
    public VehicleRepository() {
        initDatabase();
    }
    
    @Override
    public boolean save(Vehicle newVeh) {
        
        try {
            //Validate product
            if (newVeh == null || newVeh.getPlate().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Vehicle (Plate, Type) "
                    + "VALUES ( ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVeh.getPlate());
            pstmt.setString(2, newVeh.getType().toString());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT Plate, Type FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("Plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("Type")));
               
                //newVehicle.setType(TypeEnum.CAR);

                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
    
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Plate text PRIMARY KEY,\n"
                + "     Type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
