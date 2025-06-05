package org.example;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class FileService {
    public static List<String> getFilesByExtension(String directory, String extension) {
        File dir = new File(directory);
        FilenameFilter filter = (dir1, name) -> name.endsWith("." + extension);
        String[] files = dir.list(filter);
        if (files != null) return Arrays.asList(files);
        return List.of();

    }
}