package vehicle_enviroment.models;

import vehicle_enviroment.enums.CarType;

public class Car extends Vehicle {

    private CarType carType;

    public Car(String brand, String model, int year, CarType carType) {
        super(brand, model, year);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void start() {
        System.out.println("El auto arrancó!!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                '}' + super.toString();
    }

}
