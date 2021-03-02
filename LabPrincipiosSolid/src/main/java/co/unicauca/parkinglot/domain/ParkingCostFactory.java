package co.unicauca.parkinglot.domain;

/**
 *
 * @author Sergio Erazo, Juan Sanchez
 */

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;


public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> Dictionary;

    // Singleton
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        Dictionary = new EnumMap<>(TypeEnum.class);
        Dictionary.put(TypeEnum.CAR, new CarParkingCost());
        Dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        Dictionary.put(TypeEnum.TRUCK,new TruckParkingCost());        
        // Si se requie otro vehiculo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    public long CalculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        return 0;
    }
}