package ProxyPatternExample;

public class RealImage implements Image {
 private String imageUrl;

 public RealImage(String imageUrl) {
     this.imageUrl = imageUrl;
     loadImageFromServer();
 }

 private void loadImageFromServer() {
	 
     System.out.println("Loading image from " + imageUrl);
     System.out.println("Image loaded from " + imageUrl);
 }

 @Override
 public void display() {
     System.out.println("Displaying image " + imageUrl);
 }
}

