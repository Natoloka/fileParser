import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }

//            System.out.println("Content-Type = " + contentType);
//            System.out.println("Content-Disposition = " + disposition);
//            System.out.println("Content-Length = " + contentLength);
//            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }


//            TODO: complete matcher
//            Pattern findWordPattern = Pattern.compile("his");
//            for (int i = 0; i < 1000; i++) {
//                Matcher matcher = findWordPattern.matcher(myWholeFileInAString);
//                while (matcher.find()) {
//                    int offsetStart = matcher.start();
//                    int offsetEnd = matcher.end();
//
//                }
//
//                FileReader fileReader = new FileReader(fileName);
//                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//                    String line;
//                    while ((line = bufferedReader.readLine()) != null) {
//                        if (line.contains(namesArray[0])) {
//                            System.out.println(line.offsetByCodePoints());
//                        }
//
//                    }
//                }
//            ----------

                outputStream.close();
                inputStream.close();

                System.out.println("File downloaded");
            } else{
                System.out.println("No file to download. Server replied HTTP code: " + responseCode);
            }
            httpConn.disconnect();

        }
    }
