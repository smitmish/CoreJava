package Problems;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class FrequencyCount {

     public static String countFrequency(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        // LinkedHashMap preserves the order of appearance
        Map<Character, Integer> counts = new LinkedHashMap<>();
        
        for (char ch : input.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // Build the output string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        //Using Linked Hash Map to maintain the order of characters as they appear in the input string
        System.out.println(countFrequency("apple")); // Output: a1p2l1e1
        System.out.println(countFrequency("b1a1n1a1n1a1")); // Output: b11a3n2
        //Using Array to count the frequency of characters in the input string
        System.out.println(countFrequencyUsingArray("apple")); // Output: a1p2l1e1
        System.out.println(countFrequencyUsingArray("b1a1n1a1n1a1")); // Output: b11a3n2
        //Using Java 8 Streams to count the frequency of characters in the input string
        System.out.println(countFrequencyUsingStreams("apple")); // Output: a1p2l1e1
        System.out.println(countFrequencyUsingStreams("b1a1n1a1n1a1")); // Output: b11a3n2
    }

    //Using Array to count the frequency of characters in the input string
    public static String countFrequencyUsingArray(String input) {       
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Assuming ASCII characters, we can use an array of size 256
        int[] counts = new int[256];
        
        for (char ch : input.toCharArray()) {
            counts[ch]++;
        }

        // Build the output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                result.append((char) i).append(counts[i]);
            }
        }

        return result.toString();
    }


    //Using Java 8 Streams to count the frequency of characters in the input string
    public static String countFrequencyUsingStreams(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // Preserves order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + String.valueOf(entry.getValue()))
                .collect(Collectors.joining());
    }
}