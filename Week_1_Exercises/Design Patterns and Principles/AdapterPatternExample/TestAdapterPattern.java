package AdapterPatternExample;

public class TestAdapterPattern {
 public static void main(String[] args) {
     PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
     PaymentProcessor squareProcessor = new SquareAdapter(new Square());
     PaymentProcessor amazonPayProcessor = new AmazonPayAdapter(new AmazonPay());

     paypalProcessor.processPayment(100.00);
     squareProcessor.processPayment(150.00);
     amazonPayProcessor.processPayment(200.00);
 }
}

