import java.util.regex.*;

public class Main {
    public static int howMany(String sentence) {
        
        String[] potentialWords = sentence.split("\\s+");
        int wordCount = 0;

        
        Pattern wordPattern = Pattern.compile("^[a-zA-Z]+(-[a-zA-Z]+)*$");

        for (String word : potentialWords) {
            
            word = word.replaceAll("[.,?!]+$", "");

            Matcher matcher = wordPattern.matcher(word);
            if (matcher.matches()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String sentence = "How many eggs are in a half-dozen, 13?";
        System.out.println(howMany(sentence)); 
    }
}