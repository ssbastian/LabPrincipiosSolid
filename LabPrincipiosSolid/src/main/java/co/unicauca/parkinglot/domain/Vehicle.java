
package co.unicauca.parkinglot.domain;

/**
 * Clase principal donde se definen todas las caracteristicas de un vehiculo
 */

public class Vehicle {
    
    private TypeEnum type;
    private String plate;   
    private int total;
    
//CONSTRUCTOR

    public Vehicle(String plate,TypeEnum type) {
        this.type = type;
        this.plate = plate;
    }

    public Vehicle() {
    }


//GETTERS AND SETTERS

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "type=" + getType() + ", plate=" + getPlate() + '}';
    }
    
    
    
}
