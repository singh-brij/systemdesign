package in.lld.parking.sys;

import in.lld.parking.sys.payment.CostCalculator;
import in.lld.parking.sys.payment.PaymentFactory;
import in.lld.parking.sys.payment.PaymentService;
import in.lld.parking.sys.payment.PaymentType;
import in.lld.parking.vehicle.ParkingSpot;

public class ExitGate 
{
    ParkingManager manager;
    
    public ExitGate(ParkingManager manager)
    {
        this.manager = manager;
    }

    public double calculateCost(Ticket ticket)
    {
        CostCalculator costCalc = new CostCalculator();
        return costCalc.calculate(ticket);
    }

    public boolean payment(double amount, PaymentType type)
    {
        PaymentService payment = PaymentFactory.getPaymentService(type);
        return payment.makePayment(amount);
    }   

    public void remove(ParkingSpot spot)
    {
        spot.remove();
    }

}
