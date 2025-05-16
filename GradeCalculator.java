import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the student's score (0-100): ");
        int score = scanner.nextInt();
        
        // Immediately close scanner after input
        scanner.close();

        if (score < 0 || score > 100) {
            System.out.println("Error: Invalid score! Please enter a value between 0 and 100.");
            return;
        }

        char grade = determineGrade(score);
        System.out.printf("Score: %d - Final Grade: %c%n", score, grade);
    }

    private static char determineGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }
}
