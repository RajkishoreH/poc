package com.rajkishore.snappy;

import org.xerial.snappy.SnappyOutputStream;

import java.io.*;

public class DataCompressor {

    public static void compress(String srcPath, String compressPath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(srcPath);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(compressPath,true);
             SnappyOutputStream snappyOutputStream = new SnappyOutputStream(fileOutputStream)) {
            byte[] buffer = new byte[8192];
            int len;
            while((len=bufferedInputStream.read(buffer))>-1){
                snappyOutputStream.write(buffer,0,len);
            }
            snappyOutputStream.flush();
        }
    }
}
