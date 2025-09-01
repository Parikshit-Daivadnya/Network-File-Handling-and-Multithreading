import java.net.*;
import java.io.*;

public class MultiThreadDownloader extends Thread{

    private String filePath;
    private String localPath;
    private long start,end;
   // private HttpURLConnection urlConnection;

    public MultiThreadDownloader(String filePath, String localPath, long start, long end ) {
        this.filePath = filePath;
        this.localPath = localPath;
        this.start = start;
        this.end = end;
        //this.urlConnection = urlConnection;
    }

    @Override
    public void run() {

        try {
            URL url = new URL(filePath);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();


            urlConnection.setRequestProperty("Range","bytes="+start+"-"+end);

            int responseCode = urlConnection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            InputStream in = urlConnection.getInputStream();

            FileOutputStream out = new FileOutputStream(localPath);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }


            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }



    }
}
