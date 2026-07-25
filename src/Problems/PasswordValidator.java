package Problems;

public class PasswordValidator {

    // Accenture typically names this function checkPassword and expects an int return type
    public static int checkPassword(String str, int n) {
        // 1. Boundary Guard: Check for null, length mismatch, or minimum length < 4
        if (str == null || n < 4 || str.length() != n) {
            return 0;
        }

        // 2. Leading Value Restriction: Check if the first character is a number
        char firstChar = str.charAt(0);
        if (Character.isDigit(firstChar)) {
            return 0;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;

        // 3. Single-Pass Scan over the string
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            // Character Exclusions: Fail immediately if space or forward slash is found
            if (ch == ' ' || ch == '/') {
                return 0;
            }

            // Numeric Check
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } 
            // Capitalization Check
            else if (Character.isUpperCase(ch)) { 
                hasUppercase = true;
            }
        }

        // 4. Final Verification: Must meet all criteria to return 1
        if (hasDigit && hasUppercase) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test cases based on the exact platform rules
        System.out.println(checkPassword("aA1_67", 6));      // Output: 1 (Valid)
        System.out.println(checkPassword("a987 abC012", 11)); // Output: 0 (Contains space)
        System.out.println(checkPassword("1aA_67", 6));      // Output: 0 (Starts with a number)
        System.out.println(checkPassword("abc", 3));          // Output: 0 (Length less than 4)
        System.out.println(checkPassword("aA/123", 6));      // Output: 0 (Contains forward slash)
    }
}