
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import java.util.List;

/**
 * Interface que permite guardar los diferentes vehiculos
 * en una lista.
 * 
 */
public interface IVehicleRepository {
    
    boolean save(Vehicle newProduct);
    List<Vehicle> list();
    
}
