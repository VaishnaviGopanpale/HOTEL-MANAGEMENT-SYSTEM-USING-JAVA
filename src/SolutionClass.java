import java.util.*;  
import java.util.HashMap;

public class SolutionClass {
    
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);  

        String str = sc.nextLine();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == 1) {
                count++;
            }
        }

        System.out.println(count);

        sc.close(); 
    }
}
