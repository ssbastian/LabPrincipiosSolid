
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que implementa el metodo calculateCost para el calculo del total a
 * pagar de un camion que hace uso del parqueadero.
 * 
 */
public class TruckParkingCost implements IParkingCost{

    @Override
    public double calculateCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output) {

        long minutes = ChronoUnit.MINUTES.between(input, output);
        double result = 15000;
        int rand1 = (int) (Math.random() * 1000 + 1);
        int rand2 = (int) (Math.random() * 1000 + 1);

        if (rand2 == rand1) {
            System.out.println("Ganaste un servicio de parqueadero gratis.");
            return result;
        }
        if (minutes <= 720) {
            return 10000;
        } else {
            result = (minutes * vehicle.getTotal()) / 60;
            return result;
        }
    }
    
}
