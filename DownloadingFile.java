//step 1: Mention req libraries

import java.net.*;
import java.io.*;

public class DownloadingFile {
    public static void main(String[] args) throws Exception {

        //Step 2: Storing paths
        //String filePath = "https://example-files.online-convert.com/document/txt/example.txt";
        //String localPatyh=" ";

        //step 3: Initializing URL obj and opening connection

        //URL url = new URL(filePath);
        // HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        //step 4: Creationg pipes

//        try(InputStream in=urlConnection.getInputStream();)
//        {
//            FileOutputStream out = new FileOutputStream(location);
//
//            byte[] buffer = new byte[8 * 1024];
//
//            int bytesRead;
//
//            while((bytesRead= in.read(buffer))!=-1)
//            {
//                out.write(buffer,0,bytesRead);
//            }
//        }



        //Downloading file using threads
        String filePath = "https://fsn1-speed.hetzner.com/100MB.bin";
        //this special file path because not all servers support partial downloading i.e. range-based downloading
        URL url = new URL(filePath);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        int numOfThreads=4;
        long size=urlConnection.getContentLengthLong();

        urlConnection.disconnect();

        long part =size/numOfThreads;

        System.out.println(part);

        long start=0;
        long end=part;
        MultiThreadDownloader t1 = new MultiThreadDownloader(filePath,"D:\\RealWork\\thread1.txt",start,end);
        start=end;
        end=part*2;
        MultiThreadDownloader t2 = new MultiThreadDownloader(filePath,"D:\\RealWork\\thread2.txt",start,end);
        start=end;
        end=part*3;
        MultiThreadDownloader t3 = new MultiThreadDownloader(filePath,"D:\\RealWork\\thread3.txt",start,end);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Done Bro");
        return;

    }
}
