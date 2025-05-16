public class DistanceConverter {
    public static void main(String[] args) {
        int stepsTaken = 1_000_000;  // More readable with underscore
        double strideLength = 0.8;
        double totalDistance = stepsTaken * strideLength;
        int totalDistanceToInt = (int) totalDistance;
        
        System.out.printf("You took: %,d steps%n", stepsTaken);
        System.out.printf("Your stride length was %.1f meters%n", strideLength);
        System.out.printf("Total distance: %,d meters%n", totalDistanceToInt);
    }
}