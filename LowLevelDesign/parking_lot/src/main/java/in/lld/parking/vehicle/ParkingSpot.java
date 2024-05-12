package in.lld.parking.vehicle;

public class ParkingSpot 
{
    private Vehicle vehicle;
    private boolean empty;
    private final ParkingType type;

    
    public ParkingSpot(ParkingType type)
    {
        this.type = type;
        empty = true;
    }
    
    public void park(Vehicle vehicle)
    {
        if (empty == false)
        throw new RuntimeException("Parking spot is not empty : " + vehicle.getNumber());


        this.vehicle = vehicle;
        empty = false;
    }
    
    public void remove()
    {
        vehicle = null;
        empty = true;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public ParkingType getType() 
    {
        return type;
    }

    public boolean isEmpty() {
        return empty;
    }
}
