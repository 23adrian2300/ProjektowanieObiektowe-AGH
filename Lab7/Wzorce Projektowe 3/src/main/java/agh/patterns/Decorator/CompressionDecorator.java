package agh.patterns.Decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String compressedData = compress(data);
        super.writeData(compressedData);
    }

    @Override
    public String readData() {
        String compressedData = super.readData();
        return decompress(compressedData);
    }

    private String compress(String stringData) {
        try {
            byte[] input = stringData.getBytes(StandardCharsets.UTF_8);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
                gzipOutputStream.write(input);
            }
            byte[] compressedData = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(compressedData);
        } catch (IOException e) {
            System.out.println("Compression error: " + e.getMessage());
            return stringData;
        }
    }

    private String decompress(String stringData) {
        try {
            byte[] compressedData = Base64.getDecoder().decode(stringData);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(compressedData);
            try (GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
                byte[] buffer = new byte[1024];
                int length;
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                while ((length = gzipInputStream.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                return output.toString(StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.out.println("Decompression error: " + e.getMessage());
            return stringData;
        }
    }
}
