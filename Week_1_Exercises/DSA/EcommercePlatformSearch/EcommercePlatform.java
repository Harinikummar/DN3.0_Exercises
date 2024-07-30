package EcommercePlatformSearch;


public class EcommercePlatform {
    public static void main(String[] args) {

        Product[] products = new Product[]{
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobilephone", "Electronics"),
                new Product(103, "Book", "Literature"),
                new Product(104, "Eye Liner", "Cosmetics"),
                new Product(105, "Shoes", "Apparel")
        };

        //Linear Search
        System.out.println("Linear Search:");
        Product foundProduct = LinearSearch.linearSearch(products, "Book");
        
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found");
        }

        //Binary Search
        System.out.println("\nBinary Search:");

        foundProduct = BinarySearch.binarySearch(products, "Pen");
        
        if (foundProduct != null) {
            System.out.println("Product found: " + foundProduct);
        } else {
            System.out.println("Product not found");
        }
    }
}

