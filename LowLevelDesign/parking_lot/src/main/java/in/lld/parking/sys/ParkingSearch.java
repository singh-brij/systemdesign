package in.lld.parking.sys;

import java.util.List;

import in.lld.parking.vehicle.ParkingSpot;

public class ParkingSearch 
{
    public ParkingSpot search(List<ParkingSpot> spots)
    {
        for (ParkingSpot parkingSpot : spots) {
            if (parkingSpot.isEmpty())
                return parkingSpot;
        }
        
        throw new RuntimeException("Parking is full");
    }
}