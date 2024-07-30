package StrategyPatternExample;

public class TestStrategyPattern {
 public static void main(String[] args) {
     PaymentContext paymentContext = new PaymentContext();

     PaymentStrategy creditCardPayment = new CreditCardPayment("849274917840271638", "AAA", "428", "12/28");
     paymentContext.setPaymentStrategy(creditCardPayment);
     paymentContext.pay(100.00);

     PaymentStrategy payPalPayment = new PayPalPayment("aaa@example.com", "password");
     paymentContext.setPaymentStrategy(payPalPayment);
     paymentContext.pay(150.00);
 }
}
