/*Input: str = "1C0C1C1A0B1"
Expansion: ((((1 XOR 0) XOR 1) XOR 1) AND 0) OR 1
HackerRank Output: 1 
Constraints:
1) Null / Blank Verification: If the string parameter pointer is null or structurally empty, you must immediately return -1.
2) Odd Index Stepping: The layout of a valid string guarantees an odd length (e.g., length 3, 5, 7, 11) 
because digits sit at even indexes (0, 2, 4...) and operators sit at odd indexes (1, 3, 5...). 
Your loop should step by 2 to prevent pointer misalignments.
*/

package Problems;

import java.util.Scanner;

public class BitManipulation {
     public static int evaluateString(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        int res = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i += 2) {
            char op = s.charAt(i);
            int nextVal = s.charAt(i + 1) - '0';

            if (op == 'A') {
                res = res & nextVal;
            } else if (op == 'B') {
                res = res | nextVal;
            } else if (op == 'C') {
                res = res ^ nextVal;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        
        System.out.println("Output: " + evaluateString(input));
        sc.close();
    }
}   
