package in.lld.parking.sys.payment;

import in.lld.parking.sys.Log;

public class PaymentService 
{
    public boolean makePayment(double amount)
    {
        Log.info("cash payment of rs : " + amount); //ingored formatting
        return true;
    }
}
