import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        FilePartReader fpr = new FilePartReader();
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);


        try {
            String all = fpr.read();
            System.out.println(all);
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("\n Specific lines");
        String specificLines = fpr.readLines();
        System.out.println(specificLines);

        List<String> alphabeticalList = fwa.getWordsOrderedAlphabetically();
        List<String> containing = fwa.getWordsContainingSubstring("er");
        List<String> palindromes = fwa.getStringsWhichPalindromes();

        System.out.println("Alphabetical order");
        for (String s : alphabeticalList) {
            System.out.println(s);
        }
        System.out.println(" \n Contains substring");
        for (String s : containing) {
            System.out.println(s);
        }
        System.out.println("\n Palindromes");
        for (String palindrome : palindromes) {
            System.out.println(palindrome);
        }
    }

}


