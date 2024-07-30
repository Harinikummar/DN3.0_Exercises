package ProxyPatternExample;

public class TestProxyPattern {
 public static void main(String[] args) {
     Image image1 = new ProxyImage("http://example.com/image1.jpg");
     Image image2 = new ProxyImage("http://example.com/image2.jpg");

     // Image will be loaded from the server only once
     image1.display();
     System.out.println("");

     // Image will be loaded from the server only once
     image2.display();
     System.out.println("");

     // Image will be displayed without loading from the server
     image1.display();
     image2.display();
 }
}

