import speedTest.CompareSubstring;


import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\avtod\\Desktop\\dataStructures\\src\\main\\java\\speedTest\\SpeedTestFile");
        CompareSubstring compareSubstring = new CompareSubstring();

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\avtod\\Desktop\\dataStructures\\src\\main\\java\\speedTest\\compareResult"), "utf-8"))) {
            writer.write("ZAlgorithm time:  " + compareSubstring.zAlgorithmTime("agagaga", file)+"\n");
            writer.write("KnuthMorrisPratt time: "+compareSubstring.knuthMorrisPrattTime("agagaga",file)+"\n");
            writer.write("NaiveSubStringSearch time: "+compareSubstring.naiveSubStringSearchTime("agagaga",file)+"\n");
            writer.write("Trie time: "+ compareSubstring.trieTime("agagaga",file)+"\n");
            writer.write("RabbinKrap time: "+compareSubstring.rabbinKrapTime("agagaga",file)+"\n");
        }


    }
}
