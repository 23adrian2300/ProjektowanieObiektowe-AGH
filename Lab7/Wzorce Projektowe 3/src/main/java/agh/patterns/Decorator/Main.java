package agh.patterns.Decorator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = getFilePath();
        String records = "Back on track next week and heading for the hills";

        DataSource encoded = createEncodedDataSource(filePath);
        encoded.writeData(records);

        DataSource plain = createPlainDataSource(filePath);

        System.out.println("Input");
        System.out.println(records);
        System.out.println("Encoded version");
        System.out.println(plain.readData());
        System.out.println("Decoded version");
        System.out.println(encoded.readData());
    }

    private static String getFilePath() {
        Path currentPath = Paths.get("");
        String filePath = currentPath.toAbsolutePath().toString() + "/src/main/java/agh/patterns/Decorator/text.txt";
        return filePath.replace("\\", "/");
    }

    private static DataSource createEncodedDataSource(String filePath) {
        DataSource fileDataSource = new FileDataSource(filePath);
        DataSource encryptionDecorator = new EncryptionDecorator(fileDataSource);
        return new CompressionDecorator(encryptionDecorator);
    }

    private static DataSource createPlainDataSource(String filePath) {
        return new FileDataSource(filePath);
    }
}