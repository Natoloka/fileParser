import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NamesMatcher {
    String names = "James, John,Robert,Michael,William,David,Richard,Charles, Joseph, Thomas,Christopher, Daniel,Paul,Mark,D onald,George,Kenneth,Steven, Edward, Brian,Ronald,Anthony,Kevin,Jason,Matthew, Gary, Timothy,Jose,Larr y,Jeffrey,Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory,Joshua,Jerry,Dennis, Walter, Patrick, Peter, Har old,Douglas, Henry, Carl,Arthur,Ryan,Roger";
    public void checkNames(String list){
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("file.txt"), StandardCharsets.UTF_8)) {
            List<String> line = reader.lines()
                    .skip(31)
                    .limit(1)
                    .collect(Collectors.toList());

            line.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
