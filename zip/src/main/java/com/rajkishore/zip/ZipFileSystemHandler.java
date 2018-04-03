package com.rajkishore.zip;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

public enum ZipFileSystemHandler {
    INSTANCE;
    private Map<String, Object> zipFileSystemEnv = new HashMap<>();

    ZipFileSystemHandler() {
        this.zipFileSystemEnv.put("create", "true");
        this.zipFileSystemEnv.put("useTempFile",Boolean.TRUE);
    }


    public FileSystem get(String zipPath) throws IOException {
        while (true) {
            URI uri = URI.create("jar:file:" + zipPath);
            try {
                return FileSystems.newFileSystem(uri, zipFileSystemEnv);
            } catch (FileSystemAlreadyExistsException e) {
                FileSystems.getFileSystem(uri).close();
            }
        }
    }
}
