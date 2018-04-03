package com.rajkishore.snappy;

import org.xerial.snappy.SnappyInputStream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataDeCompressor {

    public static void decompress(String compressPath, String decompressPath) throws IOException {
        try(FileInputStream fileInputStream= new FileInputStream(compressPath);
            SnappyInputStream snappyInputStream = new SnappyInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(decompressPath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)){
            byte[] buffer = new byte[8192];
            int len ;
            while((len=snappyInputStream.read(buffer))>-1){
                bufferedOutputStream.write(buffer,0,len);
            }
            bufferedOutputStream.flush();
        }
    }
}
