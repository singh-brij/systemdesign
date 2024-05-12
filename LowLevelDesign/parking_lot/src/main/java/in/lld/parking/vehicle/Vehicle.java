package in.lld.parking.vehicle;

public class Vehicle 
{
    private final String number;
    private final String color;
    private final ParkingType type;
    
    public Vehicle(String vehNum, String color, ParkingType type)
    {
        this.number = vehNum;
        this.color = color;
        this.type = type;
    }

    public String getNumber() 
    {
        return number;
    }
    
    public String getColor() 
    {
        return color;
    }
    
    public ParkingType getParkingType() 
    {
        return type;
    }
}
