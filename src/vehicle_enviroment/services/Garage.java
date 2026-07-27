package vehicle_enviroment.services;

import vehicle_enviroment.models.ElectricCar;
import vehicle_enviroment.models.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

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

    //METODOS CON ITERATOR (JAVA YA IMPLEMENTA LA MAYORIA POR DEFECTO EN LAS COLECCIONES)

    public void removeAllVehicles(){
        //Esto funciona como un for each
        ListIterator<Vehicle> iterator = vehicles.listIterator();
        while(iterator.hasNext()){
            //Remove el actual
            iterator.next();
            iterator.remove();
        }
    }

    public void removeVehicle( String name){
        ListIterator<Vehicle> iterator = vehicles.listIterator();
        //iterator.next() avanza a la siguiente posición y la devuelve
        while(iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if(vehicle.getModel().equals(name)){
                //No necesito pasarle cual remover
                iterator.remove();
            }
        }
    }

    public void updateVehicle( String oldmodel, String newModel){
        ListIterator<Vehicle> iterator = vehicles.listIterator();
        while(iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if(vehicle.getModel().equals(oldmodel)){
                //Si lo quisiera reemplazar por un objeto distinto ahí si usaria el iterador
                vehicle.setModel(newModel);
                break;
            }
        }
    }


}
