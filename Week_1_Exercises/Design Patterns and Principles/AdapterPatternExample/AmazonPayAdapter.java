package AdapterPatternExample;

public class AmazonPayAdapter implements PaymentProcessor {
    private AmazonPay amazonPay;

    public AmazonPayAdapter(AmazonPay amazonPay) {
        this.amazonPay = amazonPay;
    }

    @Override
    public void processPayment(double amount) {
        amazonPay.payPayment(amount);
    }
}