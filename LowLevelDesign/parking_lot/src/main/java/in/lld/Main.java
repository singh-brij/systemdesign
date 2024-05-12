package in.lld;

import in.lld.parking.sys.ExitGate;
import in.lld.parking.sys.Log;
import in.lld.parking.sys.ParkingManager;
import in.lld.parking.sys.ParkingSearch;
import in.lld.parking.sys.ParkingSearchFactory;
import in.lld.parking.sys.ParkingSearchType;
import in.lld.parking.sys.ServiceManager;
import in.lld.parking.sys.Ticket;
import in.lld.parking.sys.payment.PaymentType;
import in.lld.parking.vehicle.MotorCycle;
import in.lld.parking.vehicle.ParkingType;
import in.lld.parking.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) 
    {
        //initializing system
        ServiceManager serviceManager = ServiceManager.getInstance();
        serviceManager.init();

        ParkingManager manager  = serviceManager.getParkingManager();
        ParkingSearch search = ParkingSearchFactory.getSearch(ParkingSearchType.NearestToEntry);
        Vehicle vehicle = new MotorCycle("MP07 9026", "Black"); 
        Ticket ticket = manager.getEntryGate(0).park(vehicle, search);

        manager.showParking(vehicle.getParkingType());

        Vehicle vehicle2 = new MotorCycle("MP07 9096", "Black"); 
        Ticket ticket2 = manager.getEntryGate(0).park(vehicle2, search);

        manager.showParking(vehicle.getParkingType());


        try
        {
            Vehicle vehicle3 = new MotorCycle("MP07 8006", "Black"); 
            Ticket ticket3 = manager.getEntryGate(0).park(vehicle3, search);

            manager.showParking(vehicle.getParkingType());
        }
        catch (RuntimeException e)
        {
            if (e.getMessage().equals(Constants.PARKING_FULL))
                Log.warn("Parking full"); 
        }

        manager.addParkingSpot(ParkingType.MotorCycle, 2);

        try
        {
            Vehicle vehicle3 = new MotorCycle("MP07 8006", "Black"); 
            Ticket ticket3 = manager.getEntryGate(0).park(vehicle3, search);

            manager.showParking(vehicle.getParkingType());
        }
        catch (RuntimeException e)
        {
            if (e.getMessage().equals(Constants.PARKING_FULL))
                Log.warn("Parking full"); 
        
        }
        
        ExitGate exitGate = manager.getExitGate(0);
     
        // remove car
        double amt = exitGate.calculateCost(ticket);
        if (exitGate.payment(amt, PaymentType.Cash))
            exitGate.remove(ticket.getParkingSpot());
        else
            Log.warn("some issue with payment for vehicle : " + vehicle.getNumber());
        
        manager.showParking(vehicle.getParkingType());

    }
}