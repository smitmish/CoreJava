/**
 * A comprehensive program to understand bitwise and bit-shift operations in Java.
 * It visualizes basic bitwise operations and demonstrates practical bit manipulation techniques.
 */
public class BitwiseManipultationDemo {

    public static void main(String[] args) {
        // Variables used for standard bitwise operations
        int a = 5;  // Binary: 0000 0101
        int b = 3;  // Binary: 0000 0011

        System.out.println("=== PART 1: BASIC BITWISE OPERATORS ===");
        
        // 1. Bitwise AND (&): Sets bit to 1 if both corresponding bits are 1
        // 0101 & 0011 = 0001 (Decimal 1)
        System.out.printf("Bitwise AND (%d & %d) = %d (Binary: %s)%n", 
                a, b, (a & b), Integer.toBinaryString(a & b));

        // 2. Bitwise OR (|): Sets bit to 1 if at least one corresponding bit is 1
        // 0101 | 0011 = 0111 (Decimal 7)
        System.out.printf("Bitwise OR  (%d | %d) = %d (Binary: %s)%n", 
                a, b, (a | b), Integer.toBinaryString(a | b));

        // 3. Bitwise XOR (^): Sets bit to 1 if corresponding bits are different
        // 0101 ^ 0011 = 0110 (Decimal 6)
        System.out.printf("Bitwise XOR (%d ^ %d) = %d (Binary: %s)%n", 
                a, b, (a ^ b), Integer.toBinaryString(a ^ b));

        // 4. Bitwise Complement (~): Inverts all 32 bits (0->1, 1->0)
        // For signed 32-bit int, ~a evaluates to -(a + 1) due to two's complement
        System.out.printf("Bitwise NOT (~%d)    = %d (Binary: %s)%n", 
                a, ~a, Integer.toBinaryString(~a));


        System.out.println("%n=== PART 2: BIT SHIFT OPERATORS ===");
        
        int shiftTarget = 12;   // Binary: 0000 1100
        int negativeTarget = -12; // Binary: 1111 1111 1111 1111 1111 1111 1111 0100

        // 5. Left Shift (<<): Shifts bits left, fills right side with 0 (multiplies by 2^n)
        // 12 << 2 = 12 * 4 = 48
        System.out.printf("Left Shift (%d << 2) = %d (Binary: %s)%n", 
                shiftTarget, (shiftTarget << 2), Integer.toBinaryString(shiftTarget << 2));

        // 6. Signed Right Shift (>>): Shifts bits right, fills left side with the sign bit
        // Keeps negative numbers negative and positive numbers positive (divides by 2^n)
        System.out.printf("Signed Right Shift (%d >> 2)   = %d (Binary: %s)%n", 
                shiftTarget, (shiftTarget >> 2), Integer.toBinaryString(shiftTarget >> 2));
        System.out.printf("Signed Right Shift (%d >> 2)  = %d (Binary: %s)%n", 
                negativeTarget, (negativeTarget >> 2), Integer.toBinaryString(negativeTarget >> 2));

        // 7. Unsigned Right Shift (>>>): Shifts bits right, always fills left side with 0
        // Turns negative integers into large positive values because the sign bit becomes 0
        System.out.printf("Unsigned Right Shift (%d >>> 2) = %d (Binary: %s)%n", 
                negativeTarget, (negativeTarget >>> 2), Integer.toBinaryString(negativeTarget >>> 2));


        System.out.println("%n=== PART 3: CORE BIT MANIPULATION TECHNIQUES ===");
        
        int number = 9; // Binary: 1001 (Bit positions from right to left starting at 0)
        int position = 1; 
        System.out.println("Starting Number: " + number + " (Binary: " + Integer.toBinaryString(number) + ")");

        // Get Bit: Extract the value of the bit at a specific position
        boolean isSet = (number & (1 << position)) != 0;
        System.out.println("-> Is bit at position " + position + " set? " + isSet);

        // Set Bit: Force the bit at a specific position to become 1
        int setMask = 1 << position;
        int afterSet = number | setMask;
        System.out.println("-> After setting bit at position " + position + ": " + afterSet + 
                " (Binary: " + Integer.toBinaryString(afterSet) + ")");

        // Clear Bit: Force the bit at a specific position to become 0
        int clearPosition = 3; // Clearing the leftmost bit of 1001
        int clearMask = ~(1 << clearPosition);
        int afterClear = number & clearMask;
        System.out.println("-> After clearing bit at position " + clearPosition + ": " + afterClear + 
                " (Binary: " + Integer.toBinaryString(afterClear) + ")");

        // Toggle Bit: Flip the bit at a specific position (0->1 or 1->0)
        int toggleMask = 1 << position;
        int afterToggle = number ^ toggleMask;
        System.out.println("-> After toggling bit at position " + position + ": " + afterToggle + 
                " (Binary: " + Integer.toBinaryString(afterToggle) + ")");
    }
}
