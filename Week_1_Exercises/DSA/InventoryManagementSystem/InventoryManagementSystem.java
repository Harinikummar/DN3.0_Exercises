package InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product(101, "Product1", 5, 100.00);
        Product product2 = new Product(102, "Product2", 6, 200.00);
        ims.addProduct(product1);
        ims.addProduct(product2);
        
        System.out.println("Displaying Product Details : ");
        ims.displayAllProducts();

        Product updatedProduct = new Product(101, "TV", 7, 500.00);
        ims.updateProduct(updatedProduct);
        
        System.out.println("\nDisplaying Product Details after updating : ");
        ims.displayAllProducts();

        ims.deleteProduct(102);

        System.out.println("\nDisplaying Product Details after deleting : ");
        ims.displayAllProducts();
    }
}