
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 * Interfaz que define el metodo IParkingCost el cual debe ser implementado por
 * la clase que use la interfaz
 * 
 */
public interface IParkingCost { //Delivery
    
    
    double calculateCost(Vehicle vehicle,LocalDateTime input,LocalDateTime output);
    
    
}
