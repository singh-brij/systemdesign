package in.lld.parking.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.lld.parking.vehicle.ParkingSpot;
import in.lld.parking.vehicle.ParkingType;

public class ParkingManager 
{
    Map<ParkingType, List<ParkingSpot>> spotsMap;
    private EntryGate entry;
    private ExitGate exit;

    public ParkingManager()
    {
        spotsMap = new HashMap<>();
        
        for (ParkingType type: ParkingType.values())
        {
            spotsMap.put(type, new ArrayList<ParkingSpot>());
        }
    }
    
    public void init()
    {
        entry = new EntryGate(this);
        exit = new ExitGate(this);
    }

    public ParkingSpot findParking(ParkingType type, ParkingSearch strategy)
    {
        return strategy.search(spotsMap.get(type));
    }

    public void remove(Ticket ticket)
    {
        ParkingSpot spot = ticket.getParkingSpot();
        spot.remove();
    }

    public void addParkingSpot(ParkingType type, List<ParkingSpot> newSpots)
    {
        for (ParkingSpot parkingSpot : newSpots)
        {
            spotsMap.get(type).add(parkingSpot);
        }
    }

    public void addParkingSpot(ParkingType type, int count)
    {
        for (int i = 0; i < count; i++)
        {
            spotsMap.get(type).add(new ParkingSpot(type));
        }
    }

    public void showParking(ParkingType type)
    {
        List<ParkingSpot> list = spotsMap.get(type);
        int i = 1;
        for (ParkingSpot spot : list)
        {
            if (spot.isEmpty())
                System.out.println(i++  + " | " + "_____" + "|");
            else
                System.out.println(i++  + " | " + "__P__" + "|");
        }
    }

    public void removeParkingSpots(List<ParkingSpot> spots)
    {
        for (ParkingSpot spot : spots)
        {
            if (spot.isEmpty())
                spotsMap.get(spot.getType()).remove(spot);
            else
                Log.warn("spot is in use can not be removed");
        }
    }

    public EntryGate getEntryGate(int num)
    {
        return entry;
    }

    public ExitGate getExitGate(int num)
    {
        return exit;
    }
}