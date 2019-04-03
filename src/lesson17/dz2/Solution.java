package lesson17.dz2;

public class Solution {
    public static void main(String[] args) {
        String test = "https://test.com";
        System.out.println(validate(test));
    }

    public static boolean validate(String address) {
        if (!address.startsWith("http://") && !address.startsWith("https://"))
            return false;

        if (!address.endsWith(".net") && !address.endsWith(".com") && !address.endsWith(".org"))
            return false;

        address = isValid(address, new String[]{"http://", "https://"});
        address = address != null && address.startsWith("www.") ? address.replaceFirst("www.", "") : address;
        address = isValid(address, new String[]{".net", ".com", "org"});

        return address != null && address.length() > 0 && checkLetterOrNumber(address);
    }

    private static String isValid(String address, String[] parts) {
        for (String part : parts) {
            if (address.contains(part)) {
                address = address.replaceFirst(part, "");
                return address;
            }
        }
        return null;
    }

    private static boolean checkLetterOrNumber(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
