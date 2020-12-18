import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextParserMain {

    ParsingHelper ph = new ParsingHelper();
    String fileUrl = "http://norvig.com/big.txt";
    String outputFilePath = "C:\\Users\\Noob Saibot\\IdeaProjects\\FileParserPrj\\target";

    DataGenerator dg = new DataGenerator();

    @Test
    public void parseTextFromFileTest() throws IOException {
        ph.parseFile(fileUrl,outputFilePath);
    }

    @Test
    public void generateMockedData(){
        dg.generateMockedData(5);
    }
}
