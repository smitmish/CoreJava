package Problems;

public class CharacterSwapper {
    public static String swapCharacters(String input, char char1, char char2) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder swappedString = new StringBuilder(input.length());

        for (char ch : input.toCharArray()) {
            if (ch == char1) {
                swappedString.append(char2);
            } else if (ch == char2) {
                swappedString.append(char1);
            } else {
                swappedString.append(ch);
            }
        }

        return swappedString.toString();
    }

    public static void main(String[] args) {
        String input = "banana boat";
        char char1 = 'a';
        char char2 = 'b';
        System.out.println("Original String: " + input);
        System.out.println("Swapped String: " + swapCharacters(input, char1, char2));
    }
}
