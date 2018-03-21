package strings.substring_search;

public final class ZAlgorithm {

    private static int [] createZarray(String s) {
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


    public static boolean containPattern(String mainString, String pattern) {
        if(pattern.length()==0 || mainString.length()==0){
            return false;
        }
        String S = pattern+"$"+mainString;
        int [] Z = createZarray(S);

        for (int aZ : Z) {
            if (aZ == pattern.length()) {
                return true;
            }
        }
        return false;
    }

}
