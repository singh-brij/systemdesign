package in.lld.parking.sys;

import in.lld.parking.vehicle.ParkingSpot;
import in.lld.parking.vehicle.Vehicle;

public class Ticket 
{
    private final Vehicle vehicle;
    private final long time;
    private final ParkingSpot spot;

    public Ticket(Vehicle vehicle, ParkingSpot spot)
    {
        this.vehicle = vehicle;
        this.spot = spot;
        time = System.currentTimeMillis();
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public long getTime()
    {
        return time;
    }

    public ParkingSpot getParkingSpot()
    {
        return spot;
    }
}
