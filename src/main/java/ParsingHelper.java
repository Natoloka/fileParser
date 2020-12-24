import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParsingHelper {
    private static final int BUFFER_SIZE = 4096;

    public void parseFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        String listOfNames = "James,\n" +
                "                John,Robert,Michael,William,David,Richard,Charles, Joseph, Thomas,Christopher,\n" +
                "                Daniel,Paul,Mark,D onald,George,Kenneth,Steven, Edward,\n" +
                "                Brian,Ronald,Anthony,Kevin,Jason,Matthew, Gary, Timothy,Jose,Larr\n" +
                "                y,Jeffrey,Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory,Joshua,Jerry,Dennis, Walter,\n" +
                "                Patrick, Peter, Har old,Douglas, Henry, Carl,Arthur,Ryan,Roger";

        String[] namesArray = listOfNames.replaceAll("(\\s|\\n)", "").split(",");
        System.out.println(namesArray);
        List<String> arrayList = Arrays.asList(namesArray);

        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            Scanner sc = null;
            sc = new Scanner(inputStream, "UTF-8");
            int counter = 0;
            int lineNumber = 1;
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                counter = counter + line.length();
                for (String name : arrayList) {
                    Pattern findWordPattern = Pattern.compile(name);

                    Matcher matcher = findWordPattern.matcher(line);
                    while (matcher.find()) {
                        int offsetStart = counter + matcher.start();
                        System.out.println(name + " " + lineNumber + " " + offsetStart);
                    }
                }
                lineNumber = lineNumber + 1;
            }
            inputStream.close();
            httpConn.disconnect();

        }
    }
}
