import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FilePartReaderTest {

    private FilePartReader fpr = new FilePartReader();

    @Test
    void setup() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fpr.setup("/home/fanni/CC/OOP/SI5/FilePartReader/test.txt", 2, 1));
    }

    @Test
    void read() throws IOException {
        Assertions.assertEquals("Alszik a tabor, latod-e draga, suhognak az almok,\n" +
                "horkan a felriado, megfordul a szuk helyen es mar\n" +
                "ujra elalszik s fenylik az arca. Csak en ulok ebren,\n" +
                "feligszitt cigarettat erzek a szamban a csokod\n" +
                "ize helyett es nem jon az alom, az enyhetado, mert\n" +
                "nem tudok en meghalni se, elni se nelkuled immar.", fpr.read());
    }

    @Test
    void readLines() throws IOException {
        Assertions.assertEquals("feligszitt cigarettat erzek a szamban a csokod /" +
                "ize helyett es nem jon az alom, az enyhetado, mert /" +
                "nem tudok en meghalni se, elni se nelkuled immar. /", fpr.readLines());
    }

    @Test
    void readIOException(){
        fpr.setup("asd", 1, 2);
        Assertions.assertThrows(IOException.class, () -> fpr.read());
    }


    @Test
    void readLineIOException(){
        fpr.setup("asd", 1, 2);
        Assertions.assertThrows(IOException.class, () -> fpr.readLines());
    }
}