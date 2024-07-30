package BuilderPatternExample;

public class Test {
    public static void main(String[] args) {
    	
        Computer personalComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("Asus ROG")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println("Personal Computer Configuration:");
        System.out.println(personalComputer);

        System.out.println("\nOffice Computer Configuration:");
        System.out.println(officeComputer);
    }
}