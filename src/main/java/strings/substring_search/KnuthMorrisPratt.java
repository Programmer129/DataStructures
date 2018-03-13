package strings.substring_search;

//import java.lang.String;


public final  class KnuthMorrisPratt {

//    private  String mainString;
//    private  String pattern;
//
//    public KnuthMorrisPratt(String mS, String p){
//        this.mainString = mS;
//        this.pattern = p;
//    }

    private int[] Compute_Prefix(String pattern){
        int size_pattern = pattern.length();
        int[] Prefix_array  = new int[size_pattern];
        if(Prefix_array.length == 0) {
            return Prefix_array;
        }
            Prefix_array[0] = 0;
            int j = 0;
            {
                for (int i = 1; i < size_pattern; ) {
                    if (pattern.charAt(i) == pattern.charAt(j)) {
                        Prefix_array[i] = j + 1;
                        i++;
                        j++;
                    } else {
                        if (j != 0) {
                            j = Prefix_array[j - 1];
                        } else {
                            Prefix_array[i] = 0;
                            i++;
                        }

                    }
                }
            }
            return Prefix_array;
    }

    private boolean is_subString(String mainString,String pattern){
        int size_mainString = mainString.length();
        int size_pattern = pattern.length();
        int[] Prefix_Array = Compute_Prefix(pattern);
        if(Prefix_Array.length!=0) {
            int q = 0;
            for (int i = 1; i < size_mainString; i++) {
                while (q > 0 && pattern.charAt(q) != mainString.charAt(i)) {
                    q = Prefix_Array[q];
                }

                if (pattern.charAt(q) == mainString.charAt(i)) {
                    q++;
                }
                if (q == size_pattern) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Is_SubString(String mainString, String pattern){
        return is_subString(mainString,pattern);
    }



}
