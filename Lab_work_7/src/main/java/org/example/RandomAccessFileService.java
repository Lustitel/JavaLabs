package org.example;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileService{
    public static void readIntArray(RandomAccessFile file, int[] array, long startPosition) throws IOException {
        file.seek(startPosition);
        for (int i = 0; i < array.length; i++) {
            array[i] = file.readInt();
        }
    }
}