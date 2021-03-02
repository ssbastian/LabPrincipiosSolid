
package co.unicauca.parkinglot.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio es la clase que concentra la lógica de negocio
 *
 */
public class Service {
    private IVehicleRepository repository;
    int result=0;
     
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }
    
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {

        if (veh.getType().equals(TypeEnum.MOTO)) {
            MotoParkingCost Moto = new MotoParkingCost();
            result = (int)Moto.calculateCost(veh, input, output);
            return result;
        }

        if (veh.getType().equals(TypeEnum.TRUCK)) {
            TruckParkingCost Truck = new TruckParkingCost();
            result = (int)Truck.calculateCost(veh, input, output);
            return result;
        }

        if (veh.getType().equals(TypeEnum.CAR)) {
            CarParkingCost Car = new CarParkingCost();
            result = (int)Car.calculateCost(veh, input, output);
            return result;
        }

        return result;
    }
    
    /**
    * 
    * Agrega un vehiculo.
    *
    */
    public boolean saveVehicle(Vehicle newVehicle) {

        //Validate product
        if (newVehicle == null ||  newVehicle.getType().toString().isEmpty()) {
            return false;
        }

        repository.save(newVehicle);
        return true;
    }
    public int aproximar(int valor) {
        int residuo = valor % 100;
        if (residuo != 0) {
            valor += 100 - residuo;
        }
        return valor;
    }
    /**
    * 
    * Lista de vehiculos.
    *
    */
    public List<Vehicle> listVehicles() {
        
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();

        return vehicles;

    }
  
}
