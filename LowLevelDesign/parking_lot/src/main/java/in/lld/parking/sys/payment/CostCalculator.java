package in.lld.parking.sys.payment;

import in.lld.parking.sys.Ticket;
import in.lld.parking.vehicle.ParkingType;

public class CostCalculator 
{
    //fixed price
    public double calculate(Ticket ticket)
    {
        if (ticket.getParkingSpot().getType() == ParkingType.MotorCycle)
            return 10;
        else if (ticket.getParkingSpot().getType() == ParkingType.Car)
            return 20;
         
        return 10;
    }
}
