//step 1: Import req libraries

import java.net.*;
import java.io.*;

public class ReadingHTMLFileOrTextFile {

    public static void main(String[] args) {

        //step 2 : Initializing URL object with file's URL
        URL url =null;
        try {
            url = new URL("https://www.learningcontainer.com/wp-content/uploads/2020/04/sample-text-file.txt\n");


        //step 2: opening the connection
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();


        //Step 3:Reading data


       BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
       // this only works for an HTML file or a text file
            // if you want to read a pdf or an image then you have to first save it using FileOutputStream

       String line;

       while((line= br.readLine())!=null)
       {
           System.out.println(line);
       }

        } catch (Exception e) {
            System.out.println("Didn't work");
            System.out.println(e.getMessage());
        }
    }
}
