package lesson31.DZ;

        import java.util.HashMap;
        import java.util.Map;

public class Solution {
    public static Map countSymbols(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                if (c != ' ')
                    map.put(c, 1);
            }
        }
        return map;
    }

    public static Map words(String text) {
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            String c = words[i];
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                if (c.length() > 1 && c != null)
                    map.put(c, 1);
            }
        }
        return map;
    }
}
