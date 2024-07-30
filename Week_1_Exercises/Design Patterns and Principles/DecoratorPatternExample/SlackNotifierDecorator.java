package DecoratorPatternExample;

//SlackNotifierDecorator.java
public class SlackNotifierDecorator extends NotifierDecorator {

 public SlackNotifierDecorator(Notifier notifier) {
     super(notifier);
 }

 @Override
 public void send(String message) {
     super.send(message);
     sendSlackMessage(message);
 }

 private void sendSlackMessage(String message) {
     System.out.println("Slack message: " + message);
 }
}
