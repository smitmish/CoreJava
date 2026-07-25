package Problems;

public class MinimumDeletion {
    void main()
    {
        String sourceString = "apple";
        String targetString = "aple";

        int deletion = minDeletion(sourceString, targetString);
        System.out.println("Minimum number of deletions required: " + deletion);

    }
    public static int minDeletion(String sourceString, String targetString) {
      if(sourceString == null || sourceString.isEmpty() || targetString == null || targetString.isEmpty()) {
          return -1; // Invalid input
      }
      int minDeletions = 0;
      int sourceIndex = 0;
      int targetIndex = 0;
      while(sourceIndex < sourceString.length() && targetIndex < targetString.length()) {
          if(sourceString.charAt(sourceIndex) == targetString.charAt(targetIndex)) {
            targetIndex++;
          }
          sourceIndex++;
      }
      if(targetIndex == targetString.length()) {
          minDeletions = sourceString.length() - targetString.length();
      } else {  
          minDeletions = -1; // Target string is not a subsequence of source string
      }
      return minDeletions;
    }
}
