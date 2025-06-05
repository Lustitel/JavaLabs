package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class RandomAccessFileServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void testReadIntArrayFromPosition() throws IOException {
        Path testFile = tempDir.resolve("test.dat");

        try (RandomAccessFile file = new RandomAccessFile(testFile.toFile(), "rw")) {
            file.writeInt(10);
            file.writeInt(20);
            file.writeInt(30);
            file.writeInt(40);
            file.writeInt(50);
        }

        int[] result = new int[2];
        try (RandomAccessFile file = new RandomAccessFile(testFile.toFile(), "r")) {
            RandomAccessFileService.readIntArray(file, result, 8);
        }

        assertArrayEquals(new int[]{30, 40}, result);
    }

    @Test
    void testReadIntArrayFromStart() throws IOException {
        Path testFile = tempDir.resolve("test_start.dat");

        try (RandomAccessFile file = new RandomAccessFile(testFile.toFile(), "rw")) {
            file.writeInt(100);
            file.writeInt(200);
        }

        int[] result = new int[2];
        try (RandomAccessFile file = new RandomAccessFile(testFile.toFile(), "r")) {
            RandomAccessFileService.readIntArray(file, result, 0);
        }

        assertArrayEquals(new int[]{100, 200}, result);
    }

    @Test
    void testEmptyArray() throws IOException {
        Path testFile = tempDir.resolve("empty_test.dat");

        try (RandomAccessFile file = new RandomAccessFile(testFile.toFile(), "rw")) {
            file.writeInt(99);
        }

        int[] emptyArray = new int[0];
        try (RandomAccessFile file = new RandomAccessFile(testFile.toFile(), "r")) {
            RandomAccessFileService.readIntArray(file, emptyArray, 0);
        }

        assertEquals(0, emptyArray.length);
    }

}