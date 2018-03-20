package speedTest;

import strings.*;
import strings.substring_search.KnuthMorrisPratt;
import strings.substring_search.NaiveSubstringSearch;
import strings.substring_search.RabinKarp;
import strings.substring_search.ZAlgorithm;

import java.io.*;


public class CompareSubstring {

    public double naiveSubStringSearchTime(String pattern, File file) throws IOException {
        long startTime = System.currentTimeMillis();


        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader((Reader) inStreamReader);
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                NaiveSubstringSearch.containPatter(st, pattern);
            }
        } catch (FileNotFoundException ms) {
            System.out.println(ms);
        }

        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime) / 1000.0;

    }

    public double knuthMorrisPrattTime(String pattern, File file) throws IOException {
        long startTime = System.currentTimeMillis();


        KnuthMorrisPratt knuthMorrisPratt = new KnuthMorrisPratt();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader((Reader) inStreamReader);
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                knuthMorrisPratt.Is_SubString(st, pattern);
            }
        } catch (FileNotFoundException ms) {
            System.out.println(ms);
        }


        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime) / 1000.0;
    }

    public double rabbinKrapTime(String pattern, File file) throws IOException {
        long startTime = System.currentTimeMillis();


        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader((Reader) inStreamReader);
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                RabinKarp.containPattern(st, pattern);
            }
        } catch (FileNotFoundException ms) {
            System.out.println(ms);
        }


        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime) / 1000.0;
    }

    public double zAlgorithmTime(String pattern, File file) throws IOException {
        long startTime = System.currentTimeMillis();
        ZAlgorithm zalgorithm = new ZAlgorithm();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader((Reader) inStreamReader);
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                zalgorithm.Is_SubString(st, pattern);
            }
        } catch (FileNotFoundException ms) {
            System.out.println(ms);
        }
        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime) / 1000.0;
    }

    public double trieTime(String pattern, File file) throws IOException {
        long startTime = System.currentTimeMillis();

        Trie trie = new Trie();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader((Reader) inStreamReader);
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                trie.insert(st);
                trie.search(pattern);
            }

        } catch (FileNotFoundException ms) {
            System.out.println(ms);
        }


        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime) / 1000.0;
    }


}



