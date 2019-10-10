import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FileWordAnalyzer {
    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    List getWordsOrderedAlphabetically() throws IOException {
        /*calls FilePartReader.readLines ()
        returns the words ordered by alphabetically as an ArrayList*/
        String raw = filePartReader.readLines();
        ArrayList<String> alphabeticalList = new ArrayList<>();
        Collections.addAll(alphabeticalList, raw.split("\\W+"));
        alphabeticalList.sort(Collator.getInstance());
        return alphabeticalList;
    }

    List getWordsContainingSubstring(String subString) throws IOException {
    /*calls FilePartReader.readLines ()
    returns the words which contains the subString*/
        String raw = filePartReader.readLines();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, raw.split("\\s+"));

        ArrayList<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            if (word.contains(subString)) {
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }

    List getStringsWhichPalindromes() throws IOException {
        /* calls FilePartReader.readLines ()
    returns the words from the String which are palindrome*/
        String raw = filePartReader.readLines();

        ArrayList<String> words = new ArrayList<>();
        List<String> palindromes = new ArrayList<>();

        Collections.addAll(words, raw.split("\\W+"));

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);

            if (sb.reverse().toString().equals(word)){
                palindromes.add(sb.toString());
            }
        }
        return palindromes;
    }
}
