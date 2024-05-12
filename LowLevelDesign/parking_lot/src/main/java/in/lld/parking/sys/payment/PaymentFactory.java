package in.lld.parking.sys.payment;

public class PaymentFactory {

    public static PaymentService getPaymentService(PaymentType type) {
        
        return new PaymentService();
    }

}
