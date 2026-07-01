package vehicle_enviroment.services;

import vehicle_enviroment.models.ElectricCar;
import vehicle_enviroment.models.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {

    //Asegura que solo se pueda agregar vehicles y no cambiar su referencia, además no obligo al usuario a pasarle la lista
    private final List<Vehicle> vehicles = new ArrayList<>();
    private int capacity;

    public Garage(int capacity) {
        this.capacity = capacity;
    }

    //Pueden traer la lista pero no modificarla, es decir, aplicarle vehicles.add, etc...
    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addVehicle(Vehicle vehicle){

        if(vehicles.size()<capacity){
            vehicles.add(vehicle);
            return true;
        }else{
            throw new IllegalStateException("El garaje está lleno, no puedes ingresar vehículos");
        }
    }

    public boolean removeVehicle(Vehicle vehicle){
        return vehicles.remove(vehicle);
    }

    public void listVehicles(){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    public void startAllVehicles(){
        for(Vehicle vehicle : vehicles){
            vehicle.start();
        }
    }

    public void chargeAllElectricCars(){
        for(Vehicle vehicle : vehicles){
            /*
            if(vehicle instanceof ElectricCar){
                ((ElectricCar) vehicle).chargeBattery();
            }
            */
            if (vehicle instanceof ElectricCar electricCar) {
                electricCar.chargeBattery();
            }
        }
    }

}
