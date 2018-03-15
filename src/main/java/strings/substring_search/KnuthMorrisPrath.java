package strings.substring_search;

public final class KnuthMorrisPrath {

    private static int [] tempArray;

    private static void createTemporaryArray(String pattern){

        tempArray = new int[pattern.length()];

        for(int i = 0, j = 1; j < pattern.length(); ){
            if(pattern.charAt(i) == pattern.charAt(j)){
                tempArray[j] = tempArray[j-1] + 1;
                i++;
                j++;
            }
            else{
                if(i != 0){
                    i = tempArray[i-1];
                }
                else{
                    j++;
                }
            }
        }
    }

    public static boolean containPattern(String text, String pattern){

        if(pattern.length() == 0 || text.length() == 0){
            return false;
        }

        createTemporaryArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        for( ; textIndex < text.length() && patternIndex < pattern.length();){
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            }
            else{
                if(patternIndex == 0){
                    textIndex++;
                }
                else {
                    patternIndex = tempArray[patternIndex - 1];
                }
            }
        }

        return patternIndex == pattern.length();
    }

}
