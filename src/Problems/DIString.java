/*  */

package Problems;
import java.util.Arrays;
import java.util.Stack;

public class DIString {
    public static int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] result = new int[n + 1];

        // Process characters from the DI string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else { // s.charAt(i) == 'D'
                result[i] = high--;
            }
        }

        // Assign the last remaining number
        result[n] = low; // configuration where low == high

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "IDID";
        System.out.println("Input: %s%n" + s1);
        System.out.println("Output: " + Arrays.toString(diStringMatch(s1)));

        // Test Case 2
        String s2 = "III";
        System.out.println("%nInput: %s%n" + s2);
        System.out.println("Output: " + Arrays.toString(diStringMatch(s2)));

        // Test Case 3
        String s3 = "DDI";
        System.out.println("%nInput: %s%n" + s3);
        System.out.println("Output: " + Arrays.toString(diStringMatch(s3)));

        System.out.println("%nUsing Stack Approach:%n");

        // Test Case 1
        s1 = "IDID";
        System.out.println("Input: %s%n" + s1);
        System.out.println("Output: " + Arrays.toString(diStringMatchUsingStack(s1)));

        // Test Case 2
        s2 = "III";
        System.out.println("%nInput: %s%n" + s2);
        System.out.println("Output: " + Arrays.toString(diStringMatchUsingStack(s2)));

        // Test Case 3
        s3 = "DDI";
        System.out.println("%nInput: %s%n" + s3);
        System.out.println("Output: " + Arrays.toString(diStringMatchUsingStack(s3)));

         //strip function practise:
        String str = "    ";
        System.out.print( "[" + str.strip() );
        str = "   hello    ";
        System.out.print( "," + str.strip() );
        str = "h i  ";
        System.out.print( "," + str.strip() + "]" );
    }

    //using stack
     public static int[] diStringMatchUsingStack(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        // Loop from 0 to n to include the final remaining element
        for (int i = 0; i <= n; i++) {
            // Push the current sequential number onto the stack
            stack.push(i);

            // If we hit 'I' or the end of the string, pop everything from the stack
            if (i == n || s.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result[index++] = stack.pop();
                }
            }
        }
        return result;
    }
}