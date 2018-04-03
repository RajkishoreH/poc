package com.rajkishore.zip;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String srcPath = "/home/rajkishoreh/vagrant-test/sampledata";
        String compressPath = "/home/rajkishoreh/vagrant-test/zipcompress.zip";
        String decompressPath = "/home/rajkishoreh/vagrant-test/zipdecompress";

        String fileName = "data";

        new File(compressPath).delete();
        new File(decompressPath).delete();

        long compressStartTime = System.currentTimeMillis();
        compressWithLoop(srcPath, compressPath, fileName);
        long compressEndTime = System.currentTimeMillis();
        System.out.println(Main.class.getCanonicalName()+" Time taken for compress :" + (compressEndTime - compressStartTime));

        long decompressStartTime = System.currentTimeMillis();
        DataDeCompressor.decompress(compressPath, fileName, decompressPath);
        long decompressEndTime = System.currentTimeMillis();
        System.out.println(Main.class.getCanonicalName()+" Time taken for decompress :" + (decompressEndTime - decompressStartTime));

    }

    private static void compressWithLoop(String srcPath, String compressPath, String fileName) throws IOException {
        for (int i = 0; i < 20; i++) {
            DataCompressor.compress(srcPath, compressPath, fileName);
        }
    }
}
