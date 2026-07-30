package Problems;

public class Palindrome {
    public static void main(String[] args) {
        String str = "racecar";
        // boolean isPalindrome = isPalindrome(str);
        // System.out.println(str + " is palindrome? " + isPalindrome);
        boolean isPalindromeRecursive = isPalindromeRecursive(12321);
        System.out.println(12321 + " is palindrome? " + isPalindromeRecursive);
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(int number) {
        // Base case: if the number has only one digit, it is a palindrome
        if (number < 10) {
            return true;
        }

        // Find the number of digits in the number
        int numDigits = (int) Math.log10(number) + 1;
        System.out.println("Number of digits: " + numDigits);

        // Get the first and last digits
        int firstDigit = (int) (number / Math.pow(10, numDigits - 1));
        System.out.println("First digit: " + firstDigit);
        int lastDigit = number % 10;
        System.out.println("Last digit: " + lastDigit);

        // If the first and last digits are not equal, it's not a palindrome
        if (firstDigit != lastDigit) {
            return false;
        }

        // Remove the first and last digits and check the remaining number
        int remainingNumber = (number % (int) Math.pow(10, numDigits - 1)) / 10;
        System.out.println("Remaining number: " + remainingNumber);

        return isPalindromeRecursive(remainingNumber);
    }
    
}
