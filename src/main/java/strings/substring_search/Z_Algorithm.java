package strings.substring_search;


import java.util.HashSet;

public class Z_Algorithm {

    private int[] Z_Array(String s) {
        int size_string = s.length();
        int[] Z = new int[size_string];
        int k = 1, r = 0, l = 0;
        for (int i = 1; i < size_string; i++) {
            if (i > r) {
                l = r = i;
                while (r < size_string && s.charAt(r) == s.charAt(r - l)) {
                    r++;
                }
                Z[i] = r - l;
                r--;
            } else {
                k = i - l;
                if (Z[k] < r - i + 1) {
                    Z[i] = Z[k];
                } else {
                    l = i;
                    while (r < size_string && s.charAt(r) == s.charAt(r - k)) {
                        r++;
                    }
                    Z[i] = r - l+1;
                    r--;
                }

            }
        }
        return Z;
    }
    /*
    Z algorithm is sub string search algorithm
    time complexity O(m+n)
    @param text
    @param pattern
    @return true if found and false otherwise
     */
    private boolean is_subString(String mainString, String pattern) {
        if(pattern.length()==0 || mainString.length()==0){
            return false;
        }
        String S = pattern+"$"+mainString;
        int[] Z = Z_Array(S);

        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == pattern.length()) {
                return true;
            }
        }
        return false;
    }
    public boolean Is_SubString(String mS,String p){ ;
        return is_subString(mS,p);
    }

}
