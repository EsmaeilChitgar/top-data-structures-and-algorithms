import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Logger {
    private final String FILE_PATH = "out/log.txt";

    public static void write(String filePath, String log) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(log);
            bufferedWriter.newLine();
        }
    }

    public static String read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
         while (bufferedReader.ready())
            sb.append(bufferedReader.readLine()).append("\n");
        }

        return sb.toString();
    }

    public static String read2(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
