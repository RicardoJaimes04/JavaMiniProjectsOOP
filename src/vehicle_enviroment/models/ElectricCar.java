package vehicle_enviroment.models;

import vehicle_enviroment.enums.CarType;
import vehicle_enviroment.interfaces.Electric;

public class ElectricCar extends Car implements Electric {

    private int batteryLevel;

    public ElectricCar(String brand, String model, int year, CarType carType, int batteryLevel) {
        super(brand, model, year, carType);
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void start(){
        System.out.println("El auto eléctrico está encendiendo..");
    }
    @Override
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Batería cargada al " + batteryLevel);

    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "batteryLevel=" + batteryLevel +
                '}' + super.toString();
    }
}
