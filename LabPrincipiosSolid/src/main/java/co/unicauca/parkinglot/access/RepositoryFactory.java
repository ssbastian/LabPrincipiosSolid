
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Sergio Erazo, Juan Sanchez
 */
public class RepositoryFactory {
    
    private static RepositoryFactory instance;
    private Map<TypeEnum, IParkingCost> deliveryDictionary;

    public RepositoryFactory() {
        deliveryDictionary = new EnumMap<>(TypeEnum.class);
        deliveryDictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
        deliveryDictionary.put(TypeEnum.CAR, new CarParkingCost());
        deliveryDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
    }
    
    /**
      * Clase singleton
     *
     * @return
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    /*
    * 
    * Método que crea una instancia concreta
    * de la jerarquia IProductRepository.
    * 
    */
    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;

    }
    
    
    public IParkingCost getVehiculo(TypeEnum vehiculo) {

        IParkingCost result = null;

        if (deliveryDictionary.containsKey(vehiculo)) {
            result = deliveryDictionary.get(vehiculo);
        }
        return result;
    }

    
}
