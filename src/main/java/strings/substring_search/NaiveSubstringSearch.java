package strings.substring_search;

public final class NaiveSubstringSearch {

    private static final int ZERO = 0;

    /**
     * naive substring search algorithm
     * time complexity O(m*n)
     * m is size of text and n is size of pattern
     * @param text
     * @param pattern
     * @return true if pattern is in text and false otherwise
     */
    public static boolean containPattern(String text, String pattern) {
        if(pattern.length() ==0 || text.length() == 0){
            return false;
        }

        int textSize = text.length();
        int patternSize = pattern.length();
        boolean contains = false;

        for(int i = 0; i <= textSize - patternSize; i++){
            int matchCounter = ZERO;
            int current = i;
            for(int j = 0; j < patternSize; j++, current++){
                matchCounter += text.charAt(current) == pattern.charAt(j) ? 1 : 0;
            }
            if(matchCounter == patternSize){
                contains = true;
                break;
            }
        }

        return contains;
    }

}
