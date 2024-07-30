package CommandPatternExample;

//CommandPatternTest.java
public class TestCommandPattern{
 public static void main(String[] args) {
     Light livingRoomLight = new Light();
     Command lightOn = new LightOnCommand(livingRoomLight);
     Command lightOff = new LightOffCommand(livingRoomLight);

     RemoteControl remote = new RemoteControl();

     // Turning the light on
     remote.setCommand(lightOn);
     remote.pressButton();

     // Turning the light off
     remote.setCommand(lightOff);
     remote.pressButton();
 }
}
