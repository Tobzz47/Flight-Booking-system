import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String input = scanner.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        scanner.close();

        boolean isPalindrome = checkPalindrome(input);
        
        System.out.println("The text \"" + input + "\" is " + 
                          (isPalindrome ? "" : "not ") + "a palindrome");
    }

    private static boolean checkPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}