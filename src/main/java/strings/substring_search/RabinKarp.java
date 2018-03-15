package strings.substring_search;

import java.util.HashMap;
import java.util.Map;

public final class RabinKarp {
    private static final int LOWER_CASE_START = 97;
    private static final int LOWER_CASE_END = 124;
    private static final int UPPER_CASE_START = 65;
    private static final int PRIME = 17;
    private static final int L_MODULE = 96;
    private static final int U_MODULE = 38;

    private static final Map<Character,Integer> dictionary = new HashMap<>();

    private static void createAlpabetHash(){
        for(int i = LOWER_CASE_START, j = UPPER_CASE_START; i < LOWER_CASE_END; i++,j++){
            dictionary.put((char)i,i - L_MODULE);
            dictionary.put((char)j,j - U_MODULE);
        }
    }

    private static int currentHash(Character last, Character next, int lastHash){
        return lastHash - dictionary.get(last)*PRIME + dictionary.get(next)*PRIME;
    }

    private static int createHash(String substring){
        int hash = 0;
        for(int i = 0; i < substring.length(); i++){
            hash += (dictionary.get(substring.charAt(i))*PRIME);
        }
        return hash;
    }

    public static boolean containPattern(String text, String pattern){

        createAlpabetHash();

        if(pattern.length() ==0 || text.length() == 0){
            return false;
        }

        int textSize = text.length();
        int patternSize = pattern.length();
        int patternHash = createHash(pattern);
        boolean contains = false;
        int hash = 0;

        for(int i = 0; i <= textSize - patternSize; i++){

            String str = text.substring(i, i+ patternSize);

            if(i == 0){
                hash = createHash(str);
            }
            else{
                hash = currentHash(text.charAt(i - 1), text.charAt(i + patternSize - 1), hash);
            }

            if(patternHash == hash){
                if(pattern.equals(str)){
                    contains = true;
                    break;
                }
            }
        }

        return contains;
    }

}
