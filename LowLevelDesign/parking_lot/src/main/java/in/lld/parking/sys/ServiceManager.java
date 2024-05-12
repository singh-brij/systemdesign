package in.lld.parking.sys;

import in.lld.parking.vehicle.ParkingType;

public class ServiceManager 
{
    private ParkingManager manager;

    private static ServiceManager Instance = new ServiceManager();

    private ServiceManager()
    {
    }

    public static ServiceManager getInstance()
    {
        return Instance;
    }

    public void init()
    {
        manager = new ParkingManager();
        manager.init();
        manager.addParkingSpot(ParkingType.MotorCycle, 2);  
        manager.addParkingSpot(ParkingType.Car, 5);

        
    }

    public ParkingManager getParkingManager()
    {
        return manager;
    }

}
