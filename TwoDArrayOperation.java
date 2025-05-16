public class TwoDArrayOperation{
    public static void main(String[] args) {
        int[][] matrix = {
            {5, 8, 2, 7},
            {3, 9, 1, 4},
            {6, 0, 11, 2}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Calculate and display total sum
        int totalSum = calculateTotalSum(matrix);
        System.out.println("\nTotal Sum of All Elements: " + totalSum);

        // Calculate and display row statistics
        displayRowStatistics(matrix);

        // Calculate and display transposed matrix
        int[][] transposed = transposeMatrix(matrix);
        System.out.println("\nTransposed Matrix:");
        printMatrix(transposed);
    }

    private static int calculateTotalSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    private static void displayRowStatistics(int[][] matrix) {
        System.out.println("\nRow Statistics:");
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int max = matrix[i][0];
            
            for (int num : matrix[i]) {
                if (num < min) min = num;
                if (num > max) max = num;
            }
            
            System.out.printf("Row %d: Min = %2d, Max = %2d%n", 
                             i + 1, min, max);
        }
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%3d ", num);
            }
            System.out.println();
        }
    }
}