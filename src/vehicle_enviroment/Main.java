package vehicle_enviroment;

import vehicle_enviroment.enums.CarType;
import vehicle_enviroment.models.*;
import vehicle_enviroment.services.Garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle myCar= new Car("Renault", "Stepway", 2022, CarType.TRUCK);
        Vehicle myElectricCar = new ElectricCar("Tesla", "model 3", 2025, CarType.SPORT, 89);

        System.out.println(myCar.toString());
        System.out.println(myElectricCar.toString());

        myCar.start();
        myElectricCar.start();

        ((ElectricCar) myElectricCar).chargeBattery();;

        List<Vehicle> listVehicles = new ArrayList<>(List.of(myCar,myElectricCar));

        System.out.println(listVehicles);

        ((ElectricCar) myElectricCar).setBatteryLevel(43);

        System.out.println("=====GARAGE======");
        Garage garage1= new Garage(5);

        garage1.addVehicle(myCar);
        garage1.addVehicle(myElectricCar);

        garage1.listVehicles();
        garage1.startAllVehicles();
        garage1.chargeAllElectricCars();
        garage1.listVehicles();

        System.out.println("=====ITERATOR=====");

        garage1.updateVehicle("Stepway", "new Stepway");
        garage1.removeVehicle("model 3");

        garage1.listVehicles();



    }

}
