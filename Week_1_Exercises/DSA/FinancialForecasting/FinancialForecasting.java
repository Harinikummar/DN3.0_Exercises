package FinancialForecasting;

public class FinancialForecasting {

    // Recursive method
    public static double calculateFutureValue(double pastValue, double growthRate, int periods) {
        if (periods == 0) {
            return pastValue;
        }
        return calculateFutureValue(pastValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double pastValue = 1000; 
        double growthRate = 0.05; 
        int periods = 10; 

        double futureValue = calculateFutureValue(pastValue, growthRate, periods);
        System.out.format("Future Value: %.3f", futureValue);
    }
}

