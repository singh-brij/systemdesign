package in.lld.parking.vehicle;

public class Car extends Vehicle
{
    private Car(String vehNum, String color)
    {
        super(vehNum, color, ParkingType.Car);
    }
}
