import java.net.*;
import java.io.*;

public class MergingParts {
    public static void main(String[] args) {
        // merging separate files one by one

        String[] filePaths=new String[3];
        filePaths[0]="D:\\RealWork\\thread1.txt";
        filePaths[1]="D:\\RealWork\\thread2.txt";
        filePaths[2]="D:\\RealWork\\thread3.txt";


        FileOutputStream out = null;
        try {
            out = new FileOutputStream("D:\\RealWork\\Merged.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<filePaths.length;i++) {
                try {
                    FileInputStream in = new FileInputStream(filePaths[i]);
                    byte[] buffer = new byte[1024*8];
                    int bytesRead;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }

                }catch (Exception e) {
                    System.out.println("OOpsi");
                    System.out.println(e);
                }
            }

        System.out.println("Done Bro");
        }
    }

