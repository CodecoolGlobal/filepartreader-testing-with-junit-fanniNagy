import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class FileWordAnalyzerTest {

    private FilePartReader fpr = new FilePartReader();
    private FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

    @Test
    void getWordsOrderedAlphabetically() throws IOException {
        List<String> result = Arrays.asList("a", "a", "alom", "az", "az", "cigarettat", "csokod", "elni", "en",
                "enyhetado", "erzek", "es", "feligszitt", "helyett", "immar", "ize", "jon", "meghalni", "mert", "nelkuled",
                "nem", "nem", "se", "se", "szamban", "tudok");
        Assertions.assertEquals(result, fwa.getWordsOrderedAlphabetically());
    }

    @Test
    void getWordsContainingSubstring() throws IOException {
        List<String> containing = Arrays.asList("erzek", "mert");
        Assertions.assertEquals(containing, fwa.getWordsContainingSubstring("er"));
    }

    @Test
    void getStringsWhichPalindromes() throws IOException {
        List<String> palindromes = Arrays.asList("a", "a");
        Assertions.assertEquals(palindromes, fwa.getStringsWhichPalindromes());
    }
}