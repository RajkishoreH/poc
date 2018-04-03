package com.rajkishore.zip;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class DataCompressor {
    public static void compress(String srcPath, String compressPath, String fileName) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(srcPath);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileSystem zipFS = ZipFileSystemHandler.INSTANCE.get(compressPath);
             OutputStream outputStream = Files.newOutputStream(zipFS.getPath(fileName), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = bufferedInputStream.read(buffer)) > -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
        }
    }
}
