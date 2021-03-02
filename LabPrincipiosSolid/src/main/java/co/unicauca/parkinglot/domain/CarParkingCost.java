
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que implementa el metodo calculateCost para el calculo del total a
 * pagar de un carro que hace uso del parqueadero.
 * 
 */
public class CarParkingCost implements IParkingCost{

    @Override
    public double calculateCost(Vehicle vehicle, LocalDateTime input, LocalDateTime output) {

        long minutes = ChronoUnit.MINUTES.between(input, output);
        double result = 2000;

        if (minutes <= 60) {
            return result;
        } else {
            result = result + ((minutes - 60) * 50 / 3);
            int residuo = (int)result % 100;
            if (residuo != 0) {
                result += 100 - residuo;
            }
            
            return result;
        }
    }

    
}
