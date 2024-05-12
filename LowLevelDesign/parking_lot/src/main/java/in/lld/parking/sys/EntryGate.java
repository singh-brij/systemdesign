package in.lld.parking.sys;

import in.lld.parking.vehicle.ParkingSpot;
import in.lld.parking.vehicle.ParkingType;
import in.lld.parking.vehicle.Vehicle;

public class EntryGate 
{
    final ParkingManager manager;

    public EntryGate(ParkingManager manager)
    {
        this.manager = manager;
    }

    public ParkingSpot findSpot(ParkingType type, ParkingSearch strategy)
    {
        return manager.findParking(type, strategy);
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot)
    {
        Ticket ticket = new Ticket(vehicle, spot);
        spot.park(vehicle);
        return ticket;
    }

    public Ticket park(Vehicle vehicle, ParkingSearch stategy) 
    {
        ParkingSpot spot = findSpot(vehicle.getParkingType(), stategy);
        Ticket ticket = generateTicket(vehicle, spot);
        return ticket;
    }
}