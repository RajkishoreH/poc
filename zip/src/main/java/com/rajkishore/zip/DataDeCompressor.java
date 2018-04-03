package com.rajkishore.zip;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.Files;

public class DataDeCompressor {
    public static void decompress(String compressPath,String fileName, String decompressPath) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(decompressPath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            FileSystem zipFS = ZipFileSystemHandler.INSTANCE.get(compressPath);
            InputStream inputStream = Files.newInputStream(zipFS.getPath(fileName))){
            byte[] buffer = new byte[8192];
            int len;
            while((len=inputStream.read(buffer))>-1){
                bufferedOutputStream.write(buffer,0,len);
            }
            bufferedOutputStream.flush();
        }
    }
}
