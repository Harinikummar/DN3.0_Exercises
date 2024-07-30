package DecoratorPatternExample;

public class TestDecoratorPattern {
 public static void main(String[] args) {
     Notifier emailNotifier = new EmailNotifier();
     Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
     Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

     smsNotifier.send("This is a SMS notification!");
     System.out.println();
     slackNotifier.send("This is a slack notification!");
 }
}
