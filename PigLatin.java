public class PigLatin {
    public static String translateToPigLatin(String str) {
        if (hasOneWord(str)) {
            return latinize(str);
        } else {
            int space = findFirstSpace(str);
            String first = str.substring(0, space);
            String rest = str.substring(space + 1, str.length());
            return latinize(first) + " " + translateToPigLatin(rest);
        }
    }

    private static int findFirstSpace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return i;
            }
        }
        return -1;
    }

    private static boolean hasOneWord(String str) {
        if (findFirstSpace(str) == -1) {
            return true;
        }
        return false;
    }


    private static String latinize(String str) {
        if (noVowel(str)) {
            str = latinizeNoVowel(str);
        } else if (beginsWithVowel(str)) {
            str = latinizeBeginsWithVowel(str);
        } else {
            str = latinizeRegular(str);
        }
        return str;
    }

    private static String latinizeRegular(String str) {
        int vowel = findFirstVowel(str);
        boolean caps = isCapitalized(str);
        String start = str.substring(0, vowel).toLowerCase();
        String end = str.substring(vowel, str.length());
        if (caps) {
            end = doCapitalize(end);
        }
        str = end + start + "ay";
        return str;
    }

    private static String doCapitalize(String str) {
        String result = ("" + str.charAt(0)).toUpperCase();
        if (str.length() > 1) {
            result += str.substring(1, str.length());
        }
        return result;
    }

    private static boolean isCapitalized(String str) {
        return !str.equals(str.toLowerCase());
    }

    private static int findFirstVowel(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isAVowel(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private static String latinizeBeginsWithVowel(String str) {
        str = str + "yay";
        return str;
    }

    private static boolean beginsWithVowel(String str) {
        if (isAVowel(str.charAt(0))) {
            return true;
        }
        return false;
    }

    private static boolean isAVowel(char c) {
        c = ("" + c).toLowerCase().charAt(0);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    private static String latinizeNoVowel(String str) {
        str = str + "ay";
        return str;
    }

    private static boolean noVowel(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isAVowel(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void testPigLatin(String str) {
        System.out.println("Original: " + str);
        str = translateToPigLatin(str);
        System.out.println("PigLatin: " + str);
    }

    public static void main(String[] args) {
        testPigLatin("Hey you Do you know how to speak in Pig Latin");
        testPigLatin("Hasta la vista baby");
    }
}

