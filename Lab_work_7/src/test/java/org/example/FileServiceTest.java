package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void findsFilesByExtension() throws IOException {
        Path txtFile = tempDir.resolve("file.txt");
        Path datFile = tempDir.resolve("file.dat");
        txtFile.toFile().createNewFile();
        datFile.toFile().createNewFile();

        List<String> result = FileService.getFilesByExtension(tempDir.toString(), "txt");

        assertEquals(List.of("file.txt"), result);
    }

    @Test
    void returnsEmptyListWhenNoMatches() throws IOException {
        tempDir.resolve("file.dat").toFile().createNewFile();

        assertTrue(FileService.getFilesByExtension(tempDir.toString(), "txt").isEmpty());
    }

    @Test
    void handlesInvalidDirectory() {
        String invalidPath = tempDir.toString() + "/nonexistent";
        assertTrue(FileService.getFilesByExtension(invalidPath, "txt").isEmpty());
    }
}